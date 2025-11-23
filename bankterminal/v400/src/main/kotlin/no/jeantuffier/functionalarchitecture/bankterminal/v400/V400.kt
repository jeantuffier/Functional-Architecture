package no.jeantuffier.functionalarchitecture.bankterminal.v400

import arrow.core.Either
import no.jeantuffier.functionalarchitecture.bankterminal.Amount
import no.jeantuffier.functionalarchitecture.bankterminal.BankTerminal
import no.jeantuffier.functionalarchitecture.bankterminal.Logger
import org.koin.dsl.module

internal class V400Sdk

internal sealed interface V400Error

internal typealias OpenConnectionDelegate = () -> Either<V400Error, V400Sdk>
internal typealias PayDelegate = (V400Sdk, Amount) -> Either<V400Error, Unit>
internal typealias CloseCommand = (V400Sdk) -> Either<V400Error, Unit>

internal class V400BankTerminal internal constructor(
    private val logger: Logger,
    private val openConnectionDelegate: OpenConnectionDelegate,
    private val payDelegate: PayDelegate,
    private val closeSettlementDelegate: CloseCommand,
    private val closeConnectionDelegate: CloseCommand,
) : BankTerminal {

    private var sdkInstance: V400Sdk? = null

    override fun openConnection() {
        openConnectionDelegate()
            .onRight {
                sdkInstance = it
                logger.info("Connection established")
            }
            .onLeft { logger.error("failed to initialise") }
    }

    override fun pay(amount: Amount) {
        sdkInstance?.let {
            payDelegate(it, amount)
                .onRight { logger.info("Transaction completed") }
                .onLeft { logger.error("Transaction failed") }
        }
    }

    override fun closeSettlement() {
        sdkInstance?.let {
            closeSettlementDelegate(it)
                .onRight { logger.info("Settlement closed") }
                .onLeft { logger.error("Failed to close settlement") }
        }
    }

    override fun closeConnection() {
        sdkInstance?.let {
            closeConnectionDelegate(it)
                .onRight { logger.info("Connection closed") }
                .onLeft { logger.error("Failed to close connection") }
        }
    }
}

val v400Module = module {
    single<BankTerminal> {
        V400BankTerminal(
            logger = get(),
            openConnectionDelegate = openConnection(get()),
            payDelegate = pay(get()),
            closeSettlementDelegate = closeSettlement(get()),
            closeConnectionDelegate = closeConnection(get()),
        )
    }
}