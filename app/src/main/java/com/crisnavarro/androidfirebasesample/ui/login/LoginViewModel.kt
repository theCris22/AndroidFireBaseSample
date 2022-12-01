package com.crisnavarro.androidfirebasesample.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.crisnavarro.androidfirebasesample.data.Resource
import com.crisnavarro.androidfirebasesample.domain.LoginFirebaseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginFirebaseUseCase: LoginFirebaseUseCase
) : ViewModel() {

    private val _loginSuccess: MutableLiveData<Resource<Boolean>> = MutableLiveData()
    val loginSuccess: LiveData<Resource<Boolean>> get() = _loginSuccess

    fun login(email: String, password: String) = viewModelScope.launch {
        _loginSuccess.value = loginFirebaseUseCase.invoke(email, password)
    }
}