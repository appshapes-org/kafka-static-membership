package org.appshapes.common.runtime

import org.appshapes.common.logging.getLogger
import org.appshapes.common.logging.inf
import org.springframework.beans.factory.DisposableBean
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner

abstract class ApplicationBase : ApplicationRunner, DisposableBean {
    protected companion object {
        val logger = getLogger()
    }

    @Value("\${org.appshapes.common.runtime.shutdown-delay}")
    private val shutdownDelay = 5000L
    private val terminationThread = Thread(::terminate)

    override fun run(args: ApplicationArguments?) {
        Runtime.getRuntime().addShutdownHook(terminationThread)
        logger.inf("Work started")
    }

    override fun destroy() {
        logger.inf("Work stopped")
    }

    protected fun terminate() {
        logger.inf("Shutting down in {} milliseconds...", shutdownDelay)
        delayTermination(shutdownDelay)
    }

    protected open fun delayTermination(delay: Long) {
        Thread.sleep(shutdownDelay)
    }
}