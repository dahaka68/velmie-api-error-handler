package com.velmie.apierrorhandler

import com.google.gson.Gson
import com.google.gson.JsonParseException
import com.google.gson.JsonSyntaxException
import java.io.IOException

class APIErrorHandler private constructor() {

    private lateinit var error: APIError
    private lateinit var throwable: Throwable
    private var errorsBody = ProcessedAPIErrorContainer(emptyList())

    constructor(error: APIError) : this() {
        this.error = error
    }

    constructor(throwable: Throwable) : this() {
        this.throwable = throwable
    }

    fun handle(exception: ResponseException): APIError {
        return if (isErrorBodyFormatted(exception)) {
            ProcessedAPIErrorContainer(convertJsonToErrorsBody(errorsBody, exception))
        } else {
            UnprocessedAPIError(
                exception,
                UnprocessedBodyEntity(
                    errorsBody.getCode(),
                    errorsBody.getTarget(),
                    errorsBody.getSource(),
                    errorsBody.getMessage()
                )
            )
        }
    }

    fun handle(throwable: Throwable): APIError {
        return RequestError(throwable)
    }

    private fun isErrorBodyFormatted(exception: ResponseException): Boolean {
        return try {
            errorsBody = Gson().fromJson(exception.getBody(), ProcessedAPIErrorContainer::class.java)
            errorsBody.getCode().isNotEmpty() && errorsBody.getTarget().body.isNotEmpty()
        } catch (ex: IOException) {
            false
        } catch (ex: JsonParseException) {
            false
        } catch (ex: JsonSyntaxException) {
            false
        }
    }

    private fun convertJsonToErrorsBody(errorsBody: ProcessedAPIErrorContainer, cause: ResponseException)
            : List<SingleProcessedAPIError> {
        val list = mutableListOf<SingleProcessedAPIError>()
        errorsBody.getErrors().forEach {
            list.add(
                SingleProcessedAPIError(
                    it.getCode(),
                    it.getTarget().body,
                    it.getSource(),
                    it.getMessage(),
                    cause
                )
            )
        }
        return list
    }
}