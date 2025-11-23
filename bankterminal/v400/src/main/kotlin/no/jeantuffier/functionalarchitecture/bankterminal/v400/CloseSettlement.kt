package no.jeantuffier.functionalarchitecture.bankterminal.v400

internal fun interface CloseSettlement {
    operator fun invoke(instance: V400Sdk)
}

internal fun CloseSettlement() = CloseSettlement {
    /**
     * This assumes we use the instance to interact with the bank terminal
     */
    println("Settlement closed")
}