package com.velmie.apierrorhandler

import java.lang.RuntimeException

class ResponseException(val code: Int, val body: String) : RuntimeException()