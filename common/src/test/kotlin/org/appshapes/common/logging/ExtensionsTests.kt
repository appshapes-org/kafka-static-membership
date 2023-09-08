package org.appshapes.common.logging

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.slf4j.event.Level
import org.slf4j.helpers.SubstituteLogger

class ExtensionsTests {
    @Test
    fun err_LogsError() {
        val logger = MockLogger()
        logger.err("Answer: {}", 42)
        assertEquals(Level.ERROR, logger.level)
        assertTrue(logger.formats.contains("Answer: {}"))
        assertTrue(logger.values.contains(42))
    }

    @Test
    fun err_LogsError_WhenThrowableIsSpecified() {
        val logger = MockLogger()
        logger.err(Exception(), "Answer: {}", 42)
        assertEquals(Level.ERROR, logger.level)
        assertTrue(logger.formats.contains("Answer: {}"))
        assertTrue(logger.values.contains(42))
        assertTrue(logger.values.any { it is Exception })
    }

    @Test
    fun wrn_LogsWarning() {
        val logger = MockLogger()
        logger.wrn("Answer: {}", 42)
        assertEquals(Level.WARN, logger.level)
        assertTrue(logger.formats.contains("Answer: {}"))
        assertTrue(logger.values.contains(42))
    }

    @Test
    fun wrn_LogsWarning_WhenThrowableIsSpecified() {
        val logger = MockLogger()
        logger.wrn(Exception(), "Answer: {}", 42)
        assertEquals(Level.WARN, logger.level)
        assertTrue(logger.formats.contains("Answer: {}"))
        assertTrue(logger.values.contains(42))
        assertTrue(logger.values.any { it is Exception })
    }

    private class MockLogger : SubstituteLogger(null, null, false) {
        var level: Level = Level.TRACE
        val formats = mutableListOf<String>()
        val values = mutableListOf<Any>()

        override fun error(format: String, vararg arguments: Any) {
            level = Level.ERROR
            formats.add(format)
            values.addAll(arguments)
        }

        override fun warn(format: String, vararg arguments: Any) {
            level = Level.WARN
            formats.add(format)
            values.addAll(arguments)
        }
    }
}