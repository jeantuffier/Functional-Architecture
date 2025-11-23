package no.jeantuffier.functionalarchitecture.bankterminal.v400

internal fun openConnection(): V400Sdk {
    // We do a bunch of initialisation thing and error handling here
    println("Connection established")
    return V400Sdk()
}