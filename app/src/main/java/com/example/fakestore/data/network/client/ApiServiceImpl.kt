package com.example.fakestore.data.network.client

import com.example.fakestore.BuildConfig
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.intOrNull
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import timber.log.Timber
import javax.inject.Inject
import kotlin.Exception

class ApiServiceImpl @Inject constructor(
    val httpClient: HttpClient,
) {

    suspend inline fun <reified T> get(
        url: String,
        host: String? = BuildConfig.HOST_BASE,
        header: Map<String, String>? = null
    ): Result<T> {
        return try {
            Result.success(httpClient.get(urlString = host + url) {
                contentType(ContentType.Application.Any)
                header?.let {
                    headers{
                        it.map { x ->
                            append(x.key, x.value)
                        }
                    }
                }

            }.body())
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }

    suspend inline fun <reified T> post(
        url: String,
        bodyJson: JsonElement? = null,
        host: String? = BuildConfig.HOST_BASE
    ): Result<T> {
        return try {

            val response = httpClient.post(urlString = host + url) {
                contentType(ContentType.Application.Json)
                if (bodyJson != null) setBody(bodyJson)
            }

            if (response.status.value !in 200..299) {
                val errorDetails = response.body<JsonElement>()
                val errorMsg = errorDetails.jsonObject["message"]?.jsonPrimitive?.content.toString()
                val statusCodeFromBody =
                    errorDetails.jsonObject["statusCode"]?.jsonPrimitive?.intOrNull
                throw Exception(errorMsg)
            }
            Result.success(
                response.body<T>()
            )
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}