package com.velmie.apierrorhandler

import com.google.gson.Gson
import com.google.gson.JsonParseException
import com.google.gson.JsonSyntaxException
import java.io.IOException

internal class GsonResponseBodyConverter(private val gson: Gson)
    : Converter<String, ProcessedAPIErrorContainer?> {

    @Throws(IOException::class)
    override fun convert(body: String): ProcessedAPIErrorContainer? {

        return try {
            gson.fromJson(body, ProcessedAPIErrorContainer::class.java)
        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        } catch (ex: JsonParseException) {
            ex.printStackTrace()
            null
        } catch (ex: JsonSyntaxException) {
            ex.printStackTrace()
            null
        }
    }
}