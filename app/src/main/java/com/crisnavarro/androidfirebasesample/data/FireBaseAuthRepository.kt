package com.crisnavarro.androidfirebasesample.data

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class FireBaseAuthRepository @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) {

    suspend fun login(email: String, password: String): Boolean {
        return try {
            var isSuccess = false

            firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnSuccessListener {
                    Log.e("SUCCESS LOGIN", it.user.toString())
                    isSuccess = true
                }
                .addOnFailureListener {
                    Log.e("FAILURE LOGIN", it.message.toString())
                    isSuccess = false
                }
                .await()
            isSuccess

        } catch (ex: Exception) {
            false
        }
    }

    suspend fun signUp(email: String, password: String): Boolean {
        return try {
            var isSuccess = false

            firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnSuccessListener {
                    Log.e("SUCCESS SIGNUP", it.user.toString())
                    isSuccess = true
                }
                .addOnFailureListener {
                    Log.e("FAILURE SIGNUP", it.message.toString())
                    isSuccess = false
                }
                .await()
            isSuccess

        } catch (ex: Exception) {
            false
        }
    }

}