package com.crisnavarro.androidfirebasesample.domain

import com.crisnavarro.androidfirebasesample.data.FireBaseAuthRepository
import javax.inject.Inject

class LoginFirebaseUseCase @Inject constructor(
    private val repository: FireBaseAuthRepository
) {

    suspend operator fun invoke(email: String, password: String) = repository.login(email, password)

}