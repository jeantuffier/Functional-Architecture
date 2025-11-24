package no.jeantuffier.functionalarchitecture.bankterminal

interface Logger {
    fun info(message: String)
    fun error(message: String)
}