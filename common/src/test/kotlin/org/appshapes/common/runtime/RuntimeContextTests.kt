package org.appshapes.common.runtime

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class RuntimeContextTests {
    @Test
    fun environment_ReturnsNonEmpty() {
        assertTrue(RuntimeContext.environment.isNotEmpty())
    }
}