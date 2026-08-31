package com.swyp.domain.common.result

sealed class ResultWrapper<out T, out E> {
    data class Success<out T>(
        val value: T,
    ) : ResultWrapper<T, Nothing>()

    data class Failure<out E>(
        val error: E,
    ) : ResultWrapper<Nothing, E>()
}
