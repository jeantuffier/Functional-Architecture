package no.jeantuffier.functionalarchitecture.bankterminal.v400

import arrow.core.right
import no.jeantuffier.functionalarchitecture.bankterminal.Logger

context(logger: Logger)
internal val openConnection: OpenConnectionDelegate
    get() = {
        // We do a bunch of initialisation thing and error handling here
        logger.info("Opening connection")
        V400Sdk().right()
    }