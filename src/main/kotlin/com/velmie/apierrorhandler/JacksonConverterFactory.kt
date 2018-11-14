package com.velmie.apierrorhandler

import com.fasterxml.jackson.databind.ObjectMapper

class JacksonConverterFactory private constructor(private val mapper: ObjectMapper)
    : Converter.Factory() {

    /**
     * Create an instance using a default {@link ObjectMapper} instance for conversion.
     */
    companion object {
        fun create(): JacksonConverterFactory {
            return create(ObjectMapper())
        }

        /**
         * Create an instance using {@code mapper} for conversion.
         */
        fun create(mapper: ObjectMapper?): JacksonConverterFactory {
            if (mapper == null) throw NullPointerException("mapper == null")
            return JacksonConverterFactory(mapper)
        }
    }

    override fun responseBodyConverter(): Converter<String, ProcessedAPIErrorContainer?> {
        return JacksonResponseBodyConverter(mapper)
    }
}