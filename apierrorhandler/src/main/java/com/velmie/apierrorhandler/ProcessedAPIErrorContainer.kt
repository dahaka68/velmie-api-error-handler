package com.velmie.apierrorhandler

class ProcessedAPIErrorContainer(private val errors: List<SingleProcessedAPIError>)
    : ResponseError { // TODO

    private val firstError
        get() = getErrors()[0]

    fun getErrors() = errors

    override fun getCode(): String {
        return firstError.getCode()
    }

    override fun getTarget(): APIErrorTarget {
        return firstError.getTarget()
    }

    override fun isTargetField(): Boolean {
        return firstError.isTargetField()
    }

    override fun isTargetCommon(): Boolean {
        return firstError.isTargetCommon()
    }

    override fun getMessage(): String? {
        return firstError.getMessage()
    }

    override fun getSource(): Map<String, String>? {
        return firstError.getSource()
    }

    override fun hasMessage(): Boolean {
        return firstError.hasMessage()
    }

    override fun hasSource(): Boolean {
        return getSource() != null
    }

    override fun getCause(): ResponseException {
        return firstError.getCause()
    }
}