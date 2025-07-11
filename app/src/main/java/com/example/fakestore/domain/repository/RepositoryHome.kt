package com.example.fakestore.domain.repository

import com.example.fakestore.data.network.model.Category
import com.example.fakestore.data.network.model.Product
import kotlinx.serialization.json.JsonElement

interface RepositoryHome {
    suspend fun getProduct(): Result<List<Product>>
    suspend fun getCategory(): Result<List<Category>>
}