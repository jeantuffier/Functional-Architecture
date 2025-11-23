package no.jeantuffier.functionalarchitecture.bankterminal.v400

import arrow.core.right
import no.jeantuffier.functionalarchitecture.bankterminal.Logger

context(logger: Logger)
internal fun pay(): PayDelegate = { instance, amount ->
    /**
     * This assumes we use the instance to interact with the bank terminal
     */
    logger.info("Executing transaction")
    Unit.right()
}