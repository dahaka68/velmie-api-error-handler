package com.velmie.apierrorhandler

import org.jetbrains.annotations.Nullable
import java.io.IOException
import java.lang.reflect.Type

interface Converter<String, ProcessedAPIErrorContainer> {

    @Nullable
    @Throws(IOException::class)
    fun convert(body: String): ProcessedAPIErrorContainer?

    abstract class Factory {
        @Nullable
        open fun responseBodyConverter(): Converter<String, ProcessedAPIErrorContainer?>? {
            return null
        }
    }
}