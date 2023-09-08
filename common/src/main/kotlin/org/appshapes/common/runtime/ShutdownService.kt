package org.appshapes.common.runtime

import org.appshapes.common.logging.err
import org.appshapes.common.logging.getLogger
import org.appshapes.common.logging.inf
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.stereotype.Service

@Service
class ShutdownService(private val applicationContext: ConfigurableApplicationContext) :
    ShutdownCommand {
    private companion object {
        val logger = getLogger()
        const val baseMessage = "Shutting down the system"
        const val exceptionMessage = "$baseMessage due to an exception"
        const val errorMessage = "$baseMessage due to an error or unknown condition"
    }

    override fun execute(t: Throwable?) {
        when (t) {
            null -> logger.inf(baseMessage)
            is Exception -> logger.err(t, exceptionMessage)
            else -> logger.err(t, errorMessage)
        }
        applicationContext.close()
    }
}