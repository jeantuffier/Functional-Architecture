package no.jeantuffier.functionalarchitecture.bankterminal.v400

import no.jeantuffier.functionalarchitecture.bankterminal.BankTerminal
import org.koin.dsl.module

internal class V400Sdk

internal class V400BankTerminal internal constructor(
    private val openConnectionDelegate: () -> V400Sdk,
    private val payDelegate: (V400Sdk, Int) -> Unit,
    private val closeSettlementDelegate: (V400Sdk) -> Unit,
    private val closeConnectionDelegate: (V400Sdk) -> Unit,
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
            openConnectionDelegate = ::openConnection,
            payDelegate = ::pay,
            closeSettlementDelegate = ::closeSettlement,
            closeConnectionDelegate = ::closeConnection,
        )
    }
}