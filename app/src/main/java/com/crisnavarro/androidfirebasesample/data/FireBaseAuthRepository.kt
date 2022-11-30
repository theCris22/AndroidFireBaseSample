package com.crisnavarro.androidfirebasesample.data

import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class FireBaseAuthRepository @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) {

    suspend fun login(email: String, password: String): Boolean {

        var isSuccess = false

        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener { isSuccess = true }
            .addOnFailureListener { isSuccess = false }
            .await()

        return isSuccess
    }

    suspend fun signUp(email: String, password: String): Boolean {
        var isSuccess = false

        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener { isSuccess = true }
            .addOnFailureListener { isSuccess = false }
            .await()

        return isSuccess
    }

}