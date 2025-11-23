package no.jeantuffier.functionalarchitecture.bankterminal.v400

import arrow.core.right
import no.jeantuffier.functionalarchitecture.bankterminal.Logger

context(logger: Logger)
internal val closeSettlement: CloseCommand
    get() = {
        /**
         * This assumes we use the instance to interact with the bank terminal
         */
        logger.info("Closing settlement")
        Unit.right()
    }