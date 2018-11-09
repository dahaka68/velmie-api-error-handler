package com.velmie.apierrorhandler.api.apiInterface

import com.velmie.apierrorhandler.APIErrorTarget

interface APIError {

    fun getCode(): String

    fun getTarget(): APIErrorTarget

    fun isTargetField(): Boolean

    fun isTargetCommon(): Boolean

    fun getMessage(): String?

    fun getSource(): Map<String, String>?

    fun hasMessage(): Boolean

    fun getCause(): Throwable
}