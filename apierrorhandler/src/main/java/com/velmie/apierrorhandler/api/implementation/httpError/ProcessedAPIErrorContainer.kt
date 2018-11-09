package com.velmie.apierrorhandler.api.implementation.httpError

import com.velmie.apierrorhandler.exceptions.ResponseException
import com.velmie.apierrorhandler.APIErrorTarget

class ProcessedAPIErrorContainer(private val errors: Array<SingleProcessedAPIError>) : SingleProcessedAPIError() {

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

    override fun getCause(): ResponseException {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}