package com.crisnavarro.androidfirebasesample.ui.signup

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.crisnavarro.androidfirebasesample.R
import com.crisnavarro.androidfirebasesample.core.isValidEmail
import com.crisnavarro.androidfirebasesample.data.Resource
import com.crisnavarro.androidfirebasesample.databinding.SignUpFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpFragment : Fragment(R.layout.sign_up_fragment) {

    private var binding: SignUpFragmentBinding? = null
    private val viewModel: SignUpViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SignUpFragmentBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initObservers()
        initListeners()
    }

    private fun initViews() = with(binding!!) {

        etEmail.doOnTextChanged { text, _, _, _ ->
            enableButton().also {
                if (text.toString().isValidEmail())
                    tilEtEmail.error = null
                else
                    tilEtEmail.error = getString(R.string.invalid_email_error)
            }
        }

        etPassword.doOnTextChanged { text, _, _, _ ->
            enableButton().also {
                if (text.toString().length >= 5)
                    tilEtPassword.error = null
                else
                    tilEtPassword.error = getString(R.string.invalid_password_error)
            }}

    }

    private fun initListeners() = with(binding!!) {

        buttonSignup.setOnClickListener {
            signUp()
        }
    }

    private fun initObservers() {

        viewModel.loginSuccess.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Error -> {
                    Log.e("ERROR", "ERROR")
                }
                is Resource.Success -> {
                    Log.e("SUCCESS", "SUCCESS")
                }
            }
        }

    }

    private fun signUp() = with(binding!!) {

        val email = etEmail.text.toString()
        val password = etPassword.text.toString()

        viewModel.signUp(email, password)
    }

    private fun enableButton() = with(binding!!) {
        buttonSignup.isEnabled =
            etEmail.text.toString().isValidEmail() && etPassword.text.toString().length >= 5
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

}