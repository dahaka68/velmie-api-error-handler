package com.velmie.apierrorhandler.api.implementation.httpError

import com.velmie.apierrorhandler.api.implementation.ResponseError
import com.velmie.apierrorhandler.exceptions.ResponseException
import com.velmie.apierrorhandler.APIErrorTarget

class UnprocessedAPIError : ResponseError {
    override fun getCause(): ResponseException {
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
}