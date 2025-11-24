package no.jeantuffier.functionalarchitecture

import no.jeantuffier.functionalarchitecture.bankterminal.BankTerminal
import no.jeantuffier.functionalarchitecture.bankterminal.Logger
import no.jeantuffier.functionalarchitecture.bankterminal.v400.v400Module
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin
import org.koin.dsl.module

val appModule = module {
    single<Logger> {
        object : Logger {
            override fun info(message: String) {
                println("info: $message")
            }

            override fun error(message: String) {
                println("error: $message")
            }
        }
    }
}

fun main() {
    startKoin {
        modules(appModule, v400Module)
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