package com.velmie.apierrorhandler

interface APIError {

    fun getCode(): String

    fun getTarget(): APIErrorTarget

    fun isTargetField(): Boolean

    fun isTargetCommon(): Boolean

    fun getMessage(): String?

    fun getSource(): Map<String, String>?

    fun hasMessage(): Boolean

    fun hasSource(): Boolean

    fun getCause(): Throwable
}