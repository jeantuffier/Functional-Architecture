package no.jeantuffier.functionalarchitecture.bankterminal.v400

import no.jeantuffier.functionalarchitecture.bankterminal.Logger

internal fun pay(logger: Logger, instance: V400Sdk, amount: Int) {
    /**
     * This assumes we use the instance to interact with the bank terminal
     */
    logger.info("Transaction completed")
}