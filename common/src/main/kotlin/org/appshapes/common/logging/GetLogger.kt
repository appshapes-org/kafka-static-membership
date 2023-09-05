package org.appshapes.common.logging

import org.slf4j.Logger
import org.slf4j.LoggerFactory

inline fun <reified T> T.getLogger(): Logger {
    val type = if (T::class.isCompanion) T::class.java.enclosingClass else T::class.java
    return LoggerFactory.getLogger(type)
}