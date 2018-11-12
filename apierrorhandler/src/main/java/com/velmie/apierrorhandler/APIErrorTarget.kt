package com.velmie.apierrorhandler

enum class APIErrorTarget(val body: String) {
    COMMON("common"), FIELD("field")
}