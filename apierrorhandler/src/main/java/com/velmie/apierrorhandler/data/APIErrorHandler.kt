package com.velmie.apierrorhandler.data

import com.velmie.apierrorhandler.api.apiInterface.APIError
import com.velmie.apierrorhandler.api.implementation.httpError.ProcessedAPIErrorContainer
import com.velmie.apierrorhandler.api.implementation.requestError.RequestError
import com.velmie.apierrorhandler.exceptions.ResponseException

class APIErrorHandler private constructor() {

    private lateinit var error: APIError
    private lateinit var throwable: Throwable

    constructor(error: APIError) : this() {
        this.error = error
    }

    constructor(throwable: Throwable) : this() {
        this.throwable = throwable
    }

    fun handle(exeption: ResponseException): APIError {
        return ProcessedAPIErrorContainer(arrayOf())  // or UnprocessedAPIError()
    }

    fun handle(throwable: Throwable): APIError {
        return RequestError()
    }
}