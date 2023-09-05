package org.appshapes.common.runtime

interface ShutdownCommand {
    fun execute(t: Throwable? = null)
}