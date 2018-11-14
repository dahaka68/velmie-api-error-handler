package com.velmie.apierrorhandler

import com.google.gson.Gson

class GsonConverterFactory private constructor(private val gson: Gson) : Converter.Factory() {

    /**
     * Create an instance using a default [Gson] instance for conversion.
     */
    companion object {
        fun create(): GsonConverterFactory {
            return create(Gson())
        }

    /**
     * Create an instance using {@code gson} for conversion.
     */
        fun create(gson: Gson?): GsonConverterFactory {
            if (gson == null) throw NullPointerException("gson == null")
            return GsonConverterFactory(gson)
        }
    }

    override fun responseBodyConverter(): Converter<String, ProcessedAPIErrorContainer?> {
        return GsonResponseBodyConverter(gson)
    }
}