package com.velmie.apierrorhandler

class UnprocessedAPIError(
    private val exception: ResponseException) : ResponseError {

    override fun getCause(): ResponseException {
        return exception
    }

    override fun getCode(): String {
        return "wrong_code" // можно создать файл с константами
    }

    override fun getTarget(): APIErrorTarget {
        return APIErrorTarget.COMMON
    }

    override fun isTargetField(): Boolean {
        return false
    }

    override fun isTargetCommon(): Boolean {
        return true
    }

    override fun getMessage(): String? {
        return "something went wrong"
    }

    override fun getSource(): Map<String, String>? {
        return null
    }

    override fun hasSource(): Boolean {
        return getSource() != null
    }

    override fun hasMessage(): Boolean {
        return getMessage() != null
    }
}