package com.velmie.apierrorhandler

open class SingleProcessedAPIError(
    private val code: String,
    private val target: String,
    private val source: Map<String, String>? = null,
    private val message: String? = null,
    private val cause: ResponseException
) : ResponseError {

    override fun getCode(): String {
        return code
    }

    override fun getTarget(): APIErrorTarget {
        return if (target == APIErrorTarget.COMMON.body) {
            APIErrorTarget.COMMON
        } else {
            APIErrorTarget.FIELD
        }
    }

    override fun isTargetField(): Boolean {
        return APIErrorTarget.FIELD.body == target
    }

    override fun isTargetCommon(): Boolean {
        return APIErrorTarget.COMMON.body == target
    }

    override fun getMessage(): String? {
        return message
    }

    override fun getSource(): Map<String, String>? {
        return source
    }

    override fun hasMessage(): Boolean {
        return !message.isNullOrEmpty()
    }

    override fun hasSource(): Boolean {
        return getSource() != null
    }

    override fun getCause(): ResponseException {
        return cause
    }
}