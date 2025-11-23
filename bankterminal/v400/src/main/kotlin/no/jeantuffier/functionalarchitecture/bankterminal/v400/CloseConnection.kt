package no.jeantuffier.functionalarchitecture.bankterminal.v400

internal fun interface CloseConnection {
    operator fun invoke(instance: V400Sdk)
}

internal fun CloseConnection() = CloseConnection {
    /**
     * This assumes we use the instance to interact with the bank terminal
     */
    println("Connection closed")
}