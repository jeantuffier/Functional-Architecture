package no.jeantuffier.functionalarchitecture.bankterminal.v400

internal class OpenConnection {

    fun openConnection(): V400Sdk {
        // We do a bunch of initialisation thing and error handling here
        return V400Sdk()
    }
}