package com.example.fakestore.data.repository

import com.example.fakestore.data.network.client.ApiServiceImpl
import com.example.fakestore.data.network.model.Category
import com.example.fakestore.data.network.model.Product
import com.example.fakestore.domain.repository.RepositoryHome
import javax.inject.Inject

class RepositoryHomeImpl @Inject constructor(
    private val apiService: ApiServiceImpl,
): RepositoryHome {
    override suspend fun getProduct(): Result<List<Product>> =
        apiService.get<List<Product>>(
            url = "/api/v1/products/",
        )


    override suspend fun getCategory(): Result<List<Category>> =
        apiService.get<List<Category>>(
            url = "/api/v1/categories/",
        )


}