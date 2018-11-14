package com.velmie.apierrorhandler

import com.fasterxml.jackson.core.JsonGenerationException
import com.fasterxml.jackson.databind.JsonMappingException
import com.fasterxml.jackson.databind.ObjectMapper
import java.io.IOException

internal class JacksonResponseBodyConverter(private val mapper: ObjectMapper)
    : Converter<String, ProcessedAPIErrorContainer?> {

    @Throws(IOException::class)
    override fun convert(body: String): ProcessedAPIErrorContainer? {

        return try {
            mapper.readValue(body, ProcessedAPIErrorContainer::class.java)
        } catch (ex: JsonGenerationException) {
            ex.printStackTrace()
            null
        } catch (ex: JsonMappingException) {
            ex.printStackTrace()
            null
        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }
}