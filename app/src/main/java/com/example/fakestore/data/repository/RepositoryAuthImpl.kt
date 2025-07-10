package com.example.fakestore.data.repository

import com.example.fakestore.data.network.client.ApiServiceImpl
import com.example.fakestore.data.network.model.Auth
import com.example.fakestore.domain.repository.RepositoryAuth
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.serializer
import javax.inject.Inject

class RepositoryAuthImpl @Inject constructor(
    private val apiService: ApiServiceImpl,
): RepositoryAuth {
    override suspend fun login(
        email: String,
        password: String
    ): Result<Auth> = apiService.post<Auth>(
            url = "/api/v1/auth/login",
            bodyJson = Json.encodeToJsonElement(
                value = mapOf(
                    "email" to email,
                    "password" to password
                ),
                serializer = Json.serializersModule.serializer()
            )
        )


}