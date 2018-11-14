package com.velmie.apierrorhandler

open class SingleProcessedAPIError(
        private val code: String,
        private val target: APIErrorTarget,
        private val source: Map<String, String>? = null,
        private val message: String? = null,
        private val cause: ResponseException? = null) : ResponseError {

    constructor(error: SingleProcessedAPIError)
            : this(error.code, error.target, error.source, error.message, error.cause)

    override fun getCode(): String {
        return code
    }

    override fun getTarget(): APIErrorTarget {
        return if (target.body == APIErrorTarget.COMMON.body) {
            APIErrorTarget.COMMON
        } else {
            APIErrorTarget.FIELD
        }
    }

    override fun isTargetField(): Boolean {
        return APIErrorTarget.FIELD.body == target.body
    }

    override fun isTargetCommon(): Boolean {
        return APIErrorTarget.COMMON.body == target.body
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

    override fun getCause(): ResponseException? {
        return cause
    }
}