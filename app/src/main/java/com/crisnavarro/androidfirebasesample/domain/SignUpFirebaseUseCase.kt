package com.crisnavarro.androidfirebasesample.domain

import com.crisnavarro.androidfirebasesample.data.FireBaseAuthRepository
import javax.inject.Inject

class SignUpFirebaseUseCase @Inject constructor(
    private val repository: FireBaseAuthRepository
) {

    suspend operator fun invoke(email: String, password: String) = repository.signUp(email, password)

}