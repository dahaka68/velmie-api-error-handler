package com.velmie.apierrorhandler

class RequestError(private val error: Throwable) : APIError {

    override fun hasSource(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCode(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getTarget(): APIErrorTarget {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isTargetField(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isTargetCommon(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getMessage(): String? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getSource(): Map<String, String>? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hasMessage(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCause(): Throwable? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}