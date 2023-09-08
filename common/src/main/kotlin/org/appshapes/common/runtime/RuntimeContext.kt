package org.appshapes.common.runtime

import org.springframework.beans.factory.annotation.Value

object RuntimeContext {
    @Value("\${spring.profiles.active}")
    val environment: String = Environments.Local
}