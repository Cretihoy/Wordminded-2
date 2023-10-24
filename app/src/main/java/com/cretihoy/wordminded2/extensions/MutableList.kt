package com.cretihoy.wordminded2.extensions

fun <T> MutableList<T>.replace(remove: T, put: T) {
    val index = indexOfOrNull(remove)
    index?.let { i ->
        set(i, put)
    }
}

fun <T> MutableList<T>.indexOfOrNull(item: T): Int? {
    val index = indexOf(item)
    return if (index == -1) {
        null
    } else {
        index
    }
}