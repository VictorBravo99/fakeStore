package com.example.fakestore.domain.repository

import com.example.fakestore.data.network.model.Category
import com.example.fakestore.data.db.entity.ProductEntity
import com.example.fakestore.data.network.model.User

interface RepositoryHome {
    suspend fun getProduct(): Result<List<ProductEntity>>
    suspend fun getCategory(): Result<List<Category>>
    suspend fun getUser(): Result<User>
}