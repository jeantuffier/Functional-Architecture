package no.jeantuffier.functionalarchitecture.bankterminal.v400

import no.jeantuffier.functionalarchitecture.bankterminal.BankTerminal
import org.koin.dsl.module

class V400 : BankTerminal {

    override fun openConnection() {
        /**
         * This assumes we use a provided SDK to interact with the bank terminal
         */
        println("Connection established")
    }

    override fun pay(amount: Int) {
        /**
         * This assumes we use a provided SDK to interact with the bank terminal
         */
        println("Transaction completed")
    }

    override fun closeSettlement() {
        /**
         * This assumes we use a provided SDK to interact with the bank terminal
         */
        println("Settlement closed")
    }

    override fun closeConnection() {
        /**
         * This assumes we use a provided SDK to interact with the bank terminal
         */
        println("Connection closed")
    }
}

val v400Module = module {
    factory<BankTerminal> {
        V400()
    }
}