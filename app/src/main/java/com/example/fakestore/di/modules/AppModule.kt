package com.example.fakestore.di.modules

import com.example.fakestore.domain.useCase.UseCase
import com.example.fakestore.domain.useCase.module.AuthUseCase
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

@dagger.Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    fun provideUseCase(authUseCase: AuthUseCase): UseCase { // Dagger will provide AuthUseCase
        return UseCase(auth = authUseCase)
    }

}