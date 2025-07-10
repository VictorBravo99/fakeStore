package com.example.fakestore.domain.repository

import com.example.fakestore.data.network.model.Auth
import kotlinx.serialization.json.JsonElement

interface RepositoryAuth {
    suspend fun login(email: String, password: String): Result<Auth>
}