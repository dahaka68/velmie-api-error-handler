package com.velmie.apierrorhandler

interface ResponseError : APIError {

    override fun getCause(): ResponseException?

}