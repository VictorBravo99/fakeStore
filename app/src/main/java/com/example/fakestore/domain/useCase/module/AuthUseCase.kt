package com.example.fakestore.domain.useCase.module

import com.example.fakestore.data.repository.RepositoryAuthImpl
import javax.inject.Inject

class AuthUseCase @Inject constructor(
    val repositoryAuth: RepositoryAuthImpl
) {
    suspend fun login(email: String, password: String) = repositoryAuth.login(email, password)
}