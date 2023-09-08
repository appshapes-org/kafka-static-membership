package org.appshapes.common.logging

import org.slf4j.Logger

fun Logger.trc(message: String, vararg values: Any) {
    this.trace(message, *values)
}

fun Logger.dbg(message: String, vararg values: Any) {
    this.debug(message, *values)
}

fun Logger.inf(message: String, vararg values: Any) {
    this.info(message, *values)
}

fun Logger.err(message: String, vararg values: Any) {
    this.error(message, *values)
}

fun Logger.err(error: Throwable, message: String, vararg values: Any) {
    this.error(message, *values, error)
}

fun Logger.wrn(error: Throwable, message: String, vararg values: Any) {
    this.warn(message, *values, error)
}

fun Logger.wrn(message: String, vararg values: Any) {
    this.warn(message, *values)
}