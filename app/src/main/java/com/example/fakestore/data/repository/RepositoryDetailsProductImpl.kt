package com.example.fakestore.data.repository

import com.example.fakestore.data.db.dao.ProductDao
import com.example.fakestore.data.db.entity.ProductEntity
import com.example.fakestore.domain.repository.RepositoryDetailsProduct
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepositoryDetailsProductImpl @Inject constructor(
    val dao: ProductDao
) : RepositoryDetailsProduct {
    override fun getDetailsProduct(id: Int): Flow<ProductEntity> = dao.loadOneByIds(id)

}