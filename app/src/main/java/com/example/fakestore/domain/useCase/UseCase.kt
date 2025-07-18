package com.example.fakestore.domain.useCase

import com.example.fakestore.domain.useCase.module.AuthUseCase
import com.example.fakestore.domain.useCase.module.DetailsProductUseCase
import com.example.fakestore.domain.useCase.module.HomeUseCase

data class UseCase(
    val auth: AuthUseCase,
    val home: HomeUseCase,
    val detailsProduct: DetailsProductUseCase
)
