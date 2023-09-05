package org.appshapes.common.runtime

import org.appshapes.common.testing.StubApplicationContext
import org.junit.jupiter.api.Test

class ShutdownServiceTests {
    @Test
    fun execute_ClosesApplicationContext_WhenThrowableIsNotSpecified() {
        val context = StubApplicationContext()
        assert(!context.closeCalled)
        ShutdownService(context).execute()
        assert(context.closeCalled)
    }

    @Test
    fun execute_ClosesApplicationContext_WhenThrowableIsSpecified() {
        val context = StubApplicationContext()
        assert(!context.closeCalled)
        ShutdownService(context).execute(Throwable())
        assert(context.closeCalled)
    }

    @Test
    fun execute_ClosesApplicationContext_WhenExceptionIsSpecified() {
        val context = StubApplicationContext()
        assert(!context.closeCalled)
        ShutdownService(context).execute(Exception())
        assert(context.closeCalled)
    }
}