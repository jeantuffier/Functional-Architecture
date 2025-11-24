package no.jeantuffier.functionalarchitecture.bankterminal.v400

import no.jeantuffier.functionalarchitecture.bankterminal.Logger

internal fun openConnection(logger: Logger): V400Sdk {
    // We do a bunch of initialisation thing and error handling here
    logger.info("Connection established")
    return V400Sdk()
}