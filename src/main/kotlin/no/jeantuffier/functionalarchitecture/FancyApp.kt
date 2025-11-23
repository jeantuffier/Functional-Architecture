package no.jeantuffier.functionalarchitecture

import no.jeantuffier.functionalarchitecture.bankterminal.BankTerminal
import no.jeantuffier.functionalarchitecture.bankterminal.v400.v400Module
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin

fun main() {
    startKoin {
        modules(v400Module)
    }

    FancyApp().run()
}

class FancyApp : KoinComponent {

    private val bankTerminal: BankTerminal by inject()

    fun run() {
        bankTerminal.openConnection()
        bankTerminal.pay(100)
        bankTerminal.closeSettlement()
        bankTerminal.closeConnection()
    }
}