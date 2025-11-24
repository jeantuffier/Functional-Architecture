package no.jeantuffier.functionalarchitecture.bankterminal.v400

import no.jeantuffier.functionalarchitecture.bankterminal.BankTerminal
import org.koin.dsl.module

class V400Sdk

class V400BankTerminal : BankTerminal {

    private var sdkInstance: V400Sdk? = null

    override fun openConnection() {
        sdkInstance = V400Sdk()
        /**
         * This assumes we use sdkInstance to interact with the bank terminal
         */
        println("Connection established")
    }

    override fun pay(amount: Int) {
        /**
         * This assumes we use sdkInstance to interact with the bank terminal
         */
        println("Transaction completed")
    }

    override fun closeSettlement() {
        /**
         * This assumes we use sdkInstance to interact with the bank terminal
         */
        println("Settlement closed")
    }

    override fun closeConnection() {
        /**
         * This assumes we use sdkInstance to interact with the bank terminal
         */
        println("Connection closed")
    }
}

val v400Module = module {
    factory<BankTerminal> {
        V400BankTerminal()
    }
}