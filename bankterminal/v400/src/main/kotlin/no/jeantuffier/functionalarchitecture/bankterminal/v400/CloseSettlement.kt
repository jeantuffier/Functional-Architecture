package no.jeantuffier.functionalarchitecture.bankterminal.v400

import no.jeantuffier.functionalarchitecture.bankterminal.Logger

internal fun closeSettlement(logger: Logger, instance: V400Sdk) {
    /**
     * This assumes we use the instance to interact with the bank terminal
     */
    logger.info("Settlement closed")
}