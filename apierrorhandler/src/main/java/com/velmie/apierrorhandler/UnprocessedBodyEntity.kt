package com.velmie.apierrorhandler

data class UnprocessedBodyEntity(val code: String? = null,
                                 val target: APIErrorTarget? = null,
                                 val source: Map<String, String>? = null,
                                 val message: String? = null)