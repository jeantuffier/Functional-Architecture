package no.jeantuffier.functionalarchitecture.bankterminal.v400

internal fun interface OpenConnection {
    operator fun invoke(): V400Sdk
}

internal fun OpenConnection() = OpenConnection {
    // We do a bunch of initialisation thing and error handling here
    println("Connection established")
    V400Sdk()
}