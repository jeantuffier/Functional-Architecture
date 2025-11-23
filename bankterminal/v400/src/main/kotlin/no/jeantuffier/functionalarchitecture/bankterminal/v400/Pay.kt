package no.jeantuffier.functionalarchitecture.bankterminal.v400

internal fun interface Pay {
    operator fun invoke(instance: V400Sdk, amount: Int)
}

internal fun Pay() = Pay { instance, amount ->
    /**
     * This assumes we use the instance to interact with the bank terminal
     */
    println("Transaction completed")
}