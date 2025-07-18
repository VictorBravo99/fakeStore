package com.example.fakestore.domain.useCase.module

import com.example.fakestore.data.repository.RepositoryDetailsProductImpl
import javax.inject.Inject

class DetailsProductUseCase @Inject constructor(
    val repositoryDetailsProduct: RepositoryDetailsProductImpl
) {
    fun getDetailsProduct(id: Int) = repositoryDetailsProduct.getDetailsProduct(id)

}