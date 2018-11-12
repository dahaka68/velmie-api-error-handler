package com.velmie.apierrorhandler

class APIErrorHandler private constructor() {

    fun handle(exeption: ResponseException): APIError {
        return ProcessedAPIErrorContainer(arrayOf())  // or UnprocessedAPIError()
    }

    fun handle(throwable: Throwable): APIError {
        return RequestError(throwable)
    }
}