package com.crisnavarro.androidfirebasesample.domain

import com.crisnavarro.androidfirebasesample.data.FireBaseAuthRepository
import com.crisnavarro.androidfirebasesample.data.Resource
import javax.inject.Inject

class SignUpFirebaseUseCase @Inject constructor(
    private val repository: FireBaseAuthRepository
) {

    suspend operator fun invoke(email: String, password: String): Resource<Boolean> {
        return if (repository.signUp(email, password))
            Resource.Success(true)
        else
            Resource.Error("ERROR")
    }

}