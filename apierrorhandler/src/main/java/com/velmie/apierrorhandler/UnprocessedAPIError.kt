package com.velmie.apierrorhandler

class UnprocessedAPIError(
    private val exception: ResponseException,
    private val errorEntity: UnprocessedBodyEntity
) :
    ResponseError {

    override fun getCause(): ResponseException {
        return exception
    }

    override fun getCode(): String {
       return errorEntity.code ?: "wrong_code" // можно создать файл с константами
    }

    override fun getTarget(): APIErrorTarget {
        return errorEntity.target ?: APIErrorTarget.COMMON
    }

    override fun isTargetField(): Boolean {
        return errorEntity.target?.body == APIErrorTarget.FIELD.body
    }

    override fun isTargetCommon(): Boolean {
        return errorEntity.target?.body == APIErrorTarget.COMMON.body
    }

    override fun getMessage(): String? {
        return errorEntity.message
    }

    override fun getSource(): Map<String, String>? {
        return errorEntity.source
    }

    override fun hasSource(): Boolean {
        return getSource() != null
    }

    override fun hasMessage(): Boolean {
        return getMessage() != null
    }
}