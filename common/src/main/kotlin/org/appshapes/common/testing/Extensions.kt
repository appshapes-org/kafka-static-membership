package org.appshapes.common.testing

import java.lang.reflect.Field

fun Any.setValue(name: String, value: Any?, type: Class<*> = this::class.java) {
    type
        .getDeclaredField(name, true)
        .set(this, value)
}

fun Any.getValue(name: String, type: Class<*> = this::class.java): Any? {
    return type
        .getDeclaredField(name, true)
        .get(this)
}

fun Class<*>.getDeclaredField(name: String, isAccessible: Boolean): Field {
    val field = getDeclaredField(name)
    field.isAccessible = isAccessible
    return field
}