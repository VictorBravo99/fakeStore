package com.example.fakestore.domain.repository

import com.example.fakestore.data.db.entity.ProductEntity
import kotlinx.coroutines.flow.Flow

interface RepositoryDetailsProduct {
    fun getDetailsProduct(id: Int): Flow<ProductEntity>
}