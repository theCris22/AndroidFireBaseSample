package com.crisnavarro.androidfirebasesample.ui.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.crisnavarro.androidfirebasesample.data.Resource
import com.crisnavarro.androidfirebasesample.domain.SignUpFirebaseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val signUpFirebaseUseCase: SignUpFirebaseUseCase
) : ViewModel() {

    private val _signupSuccess: MutableLiveData<Resource<Boolean>> = MutableLiveData()
    val signupSuccess: LiveData<Resource<Boolean>> get() = _signupSuccess

    fun signUp(email: String, password: String) = viewModelScope.launch {
        _signupSuccess.postValue(signUpFirebaseUseCase.invoke(email, password))
    }

}