package no.jeantuffier.functionalarchitecture.bankterminal.v400

import arrow.core.Either
import arrow.core.right
import no.jeantuffier.functionalarchitecture.bankterminal.Amount
import no.jeantuffier.functionalarchitecture.bankterminal.Logger

internal fun pay(logger: Logger, instance: V400Sdk, amount: Amount): Either<V400Error, Unit> {
    /**
     * This assumes we use the instance to interact with the bank terminal
     */
    logger.info("Executing transaction")
    return Unit.right()
}