package com.velmie.apierrorhandler

class APIErrorHandler {

    private var errorsBody = ProcessedAPIErrorContainer(emptyArray())

    fun handle(exception: ResponseException,
               converter: Converter<String, ProcessedAPIErrorContainer?>): APIError {
        return if (isErrorBodyFormatted(exception, converter)) {
            ProcessedAPIErrorContainer(converter.convert(exception.body)?.errors
                    ?: emptyArray()) // или можно !!
        } else {
            UnprocessedAPIError(exception)
        }
    }

    fun handle(throwable: Throwable): APIError {
        return RequestError(throwable)
    }

    private fun isErrorBodyFormatted(
            exception: ResponseException,
            converter: Converter<String, ProcessedAPIErrorContainer?>
    ): Boolean {
        val errorBody = converter.convert(exception.body)
        return !errorBody?.getCode().isNullOrEmpty() && errorsBody.getTarget().body.isNotEmpty()
    }
}