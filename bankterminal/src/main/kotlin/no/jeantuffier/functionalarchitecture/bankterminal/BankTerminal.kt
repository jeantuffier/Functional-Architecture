package no.jeantuffier.functionalarchitecture.bankterminal

@JvmInline
value class Amount(val value: Int)

interface BankTerminal {
    fun openConnection()
    fun pay(amount: Amount)
    fun closeSettlement()
    fun closeConnection()
}