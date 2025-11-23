package no.jeantuffier.functionalarchitecture.bankterminal.v400

import arrow.core.right
import no.jeantuffier.functionalarchitecture.bankterminal.Logger

internal fun closeConnection(logger: Logger): CloseCommand  = {
    /**
     * This assumes we use the instance to interact with the bank terminal
     */
    logger.info("Closing connection")
    Unit.right()
}