package com.velmie.apierrorhandler

import java.lang.RuntimeException

class ResponseException(private val code: Int, private val body: String) : RuntimeException() {

    fun getCode() = code

    fun getBody() = body
}