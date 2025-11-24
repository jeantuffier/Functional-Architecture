package no.jeantuffier.functionalarchitecture.bankterminal.v400

import no.jeantuffier.functionalarchitecture.bankterminal.BankTerminal
import no.jeantuffier.functionalarchitecture.bankterminal.Logger
import org.koin.dsl.module

internal class V400Sdk

internal class V400BankTerminal internal constructor(
    private val logger: Logger,
    private val openConnectionDelegate: (Logger) -> V400Sdk,
    private val payDelegate: (Logger, V400Sdk, Int) -> Unit,
    private val closeSettlementDelegate: (Logger, V400Sdk) -> Unit,
    private val closeConnectionDelegate: (Logger, V400Sdk) -> Unit,
) : BankTerminal {

    private var sdkInstance: V400Sdk? = null

    override fun openConnection() {
        sdkInstance = openConnectionDelegate(logger)
    }

    override fun pay(amount: Int) {
        sdkInstance?.let { payDelegate(logger, it, amount) }
    }

    override fun closeSettlement() {
        sdkInstance?.let { closeSettlementDelegate(logger, it) }
    }

    override fun closeConnection() {
        sdkInstance?.let { closeConnectionDelegate(logger, it) }
    }
}

val v400Module = module {
    single<BankTerminal> {
        V400BankTerminal(
            logger = get(),
            openConnectionDelegate = ::openConnection,
            payDelegate = ::pay,
            closeSettlementDelegate = ::closeSettlement,
            closeConnectionDelegate = ::closeConnection,
        )
    }
}