package com.velmie.apierrorhandler.api.implementation

import com.velmie.apierrorhandler.api.apiInterface.APIError
import com.velmie.apierrorhandler.exceptions.ResponseException

interface ResponseError : APIError {

    override fun getCause(): ResponseException

}