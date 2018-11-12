package com.velmie.apierrorhandler

class RequestError(private val error: Throwable) : APIError {

    override fun hasSource(): Boolean {
        return getSource() != null
    }

    override fun getCode(): String {
        return "wrong_request"
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
        return error.message
    }

    override fun getSource(): Map<String, String>? {
        return null
    }

    override fun hasMessage(): Boolean {
        return !error.message.isNullOrEmpty()
    }

    override fun getCause(): Throwable {
        return error
    }
}