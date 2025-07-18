package com.example.fakestore.di.modules

import com.example.fakestore.domain.useCase.UseCase
import com.example.fakestore.domain.useCase.module.AuthUseCase
import com.example.fakestore.domain.useCase.module.DetailsProductUseCase
import com.example.fakestore.domain.useCase.module.HomeUseCase
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@dagger.Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideUseCase(
        authUseCase: AuthUseCase,
        homeUseCase: HomeUseCase,
        detailsProductUseCase: DetailsProductUseCase
    ): UseCase {
        return UseCase(
            auth = authUseCase,
            home = homeUseCase,
            detailsProduct = detailsProductUseCase
        )
    }

}