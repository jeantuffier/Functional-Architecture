package no.jeantuffier.functionalarchitecture.bankterminal

interface BankTerminal {
    fun openConnection()
    fun pay(amount: Int)
    fun closeSettlement()
    fun closeConnection()
}