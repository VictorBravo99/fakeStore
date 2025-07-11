package com.example.fakestore.domain.useCase.module

import com.example.fakestore.data.repository.RepositoryHomeImpl
import javax.inject.Inject

class HomeUseCase@Inject constructor(
    val repositoryHome: RepositoryHomeImpl
) {
    suspend fun getProduct() = repositoryHome.getProduct()
    suspend fun getCategory() = repositoryHome.getCategory()
}