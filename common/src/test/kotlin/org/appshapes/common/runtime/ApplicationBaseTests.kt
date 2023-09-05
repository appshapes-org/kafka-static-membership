package org.appshapes.common.runtime

import org.appshapes.common.testing.getValue
import org.appshapes.common.testing.setValue
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ApplicationBaseTests {
    @Test
    fun constructor_ReturnsInstance() {
        assertNotNull(StubApplication())
    }

    @Test
    fun run_AddsShutdownHook() {
        val application = StubApplication()
        assertFalse(Runtime.getRuntime().removeShutdownHook(application.getTerminateThread()))
        application.run(null)
        assertTrue(Runtime.getRuntime().removeShutdownHook(application.getTerminateThread()))
    }

    @Test
    fun terminate_CallsDelayTermination() {
        val application = StubApplication()
        assertEquals(0, application.delayTerminationCalled)
        application.invokeTerminate()
        assertEquals(1, application.delayTerminationCalled)
    }

    @Test
    fun destroy_ReturnsWithoutThrowing() {
        StubApplication().destroy()
    }

    private class StubApplication : ApplicationBase() {
        var delayTerminationCalled = 0

        init {
            setValue("shutdownDelay", 1L, ApplicationBase::class.java)
        }

        fun getTerminateThread() = getValue("terminationThread", ApplicationBase::class.java) as Thread

        fun invokeTerminate() = terminate()

        override fun delayTermination(delay: Long) {
            super.delayTermination(delay)
            ++delayTerminationCalled
        }
    }
}