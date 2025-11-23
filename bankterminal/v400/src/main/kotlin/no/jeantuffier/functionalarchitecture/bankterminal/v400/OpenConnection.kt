package no.jeantuffier.functionalarchitecture.bankterminal.v400

import arrow.core.Either
import arrow.core.right
import no.jeantuffier.functionalarchitecture.bankterminal.Logger

internal fun openConnection(logger: Logger): Either<V400Error, V400Sdk> {
    // We do a bunch of initialisation thing and error handling here
    logger.info("Opening connection")
    return V400Sdk().right()
}