package com.example.fakestore.data.repository

import com.example.fakestore.data.db.dao.ProductDao
import com.example.fakestore.data.network.client.ApiServiceImpl
import com.example.fakestore.data.network.model.Category
import com.example.fakestore.data.db.entity.ProductEntity
import com.example.fakestore.domain.repository.RepositoryHome
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RepositoryHomeImpl @Inject constructor(
    private val apiService: ApiServiceImpl,
    private val productDao: ProductDao
): RepositoryHome {
    override suspend fun getProduct(): Result<List<ProductEntity>> {

        val products = apiService.get<List<ProductEntity>>(
            url = "/api/v1/products/",
        )

        products.onSuccess { productList ->
            withContext(Dispatchers.IO) {
                productDao.insertAll(productList)
            }
        }

        return products


    }


    override suspend fun getCategory(): Result<List<Category>> =
        apiService.get<List<Category>>(
            url = "/api/v1/categories/",
        )


}