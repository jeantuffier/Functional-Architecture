package no.jeantuffier.functionalarchitecture.bankterminal.v400

import no.jeantuffier.functionalarchitecture.bankterminal.BankTerminal
import org.koin.dsl.module

internal class V400Sdk

internal class V400BankTerminal internal constructor(
    private val openConnectionDelegate: OpenConnection,
    private val payDelegate: Pay,
    private val closeSettlementDelegate: CloseSettlement,
    private val closeConnectionDelegate: CloseConnection,
) : BankTerminal {

    private var sdkInstance: V400Sdk? = null

    override fun openConnection() {
        sdkInstance = openConnectionDelegate()
    }

    override fun pay(amount: Int) {
        sdkInstance?.let { payDelegate(it, amount) }
    }

    override fun closeSettlement() {
        sdkInstance?.let { closeSettlementDelegate(it) }
    }

    override fun closeConnection() {
        sdkInstance?.let { closeConnectionDelegate(it) }
    }
}

val v400Module = module {
    factory<BankTerminal> {
        V400BankTerminal(
            openConnectionDelegate = OpenConnection(),
            payDelegate = Pay(),
            closeSettlementDelegate = CloseSettlement(),
            closeConnectionDelegate = CloseConnection(),
        )
    }
}