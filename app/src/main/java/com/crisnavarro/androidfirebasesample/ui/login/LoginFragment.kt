package com.crisnavarro.androidfirebasesample.ui.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.crisnavarro.androidfirebasesample.R
import com.crisnavarro.androidfirebasesample.core.isValidEmail
import com.crisnavarro.androidfirebasesample.data.Resource
import com.crisnavarro.androidfirebasesample.databinding.LoginFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment(R.layout.login_fragment) {

    private val viewModel: LoginViewModel by viewModels()
    private var binding: LoginFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = LoginFragmentBinding.inflate(layoutInflater, container, false)
        return binding!!.root
    }

    override fun onStart() {
        super.onStart()
        with(binding!!) {
            tilEtEmail.error = null
            tilEtPassword.error = null
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initListeners()
        initObservers()
    }

    private fun initViews() = with(binding!!) {

        etEmail.doOnTextChanged { text, _, _, _ ->
            enableLoginButton().also {
                if (text.toString().isValidEmail())
                    tilEtEmail.error = null
                else
                    tilEtEmail.error = getString(R.string.invalid_email_error)
            }
        }
        etPassword.doOnTextChanged { text, _, _, _ ->
            enableLoginButton().also {
                if (text.toString().length >= 5)
                    tilEtPassword.error = null
                else
                    tilEtPassword.error = getString(R.string.invalid_password_error)
            }
        }
    }

    private fun initListeners() = with(binding!!) {

        buttonLogin.setOnClickListener { login() }
        buttonSignup.setOnClickListener { findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToSignUpFragment()) }
        buttonForgotPassword.setOnClickListener {
            findNavController().navigate(
                LoginFragmentDirections.actionLoginFragmentToRecoverPasswordFragment()
            )
        }

    }

    private fun initObservers() {

        viewModel.loginSuccess.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Error -> {
                    Log.e("ERROR", "HERE")
                }
                is Resource.Success -> {
                    Log.e("SUCCESS", "HERE")
                    goToHome()
                }
            }
        }
    }

    private fun goToHome() {
        findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToHomeFragment())
    }

    private fun login() = with(binding!!) {

        val email = etEmail.text.toString()
        val password = etPassword.text.toString()

        viewModel.login(email, password)

    }

    private fun enableLoginButton() = with(binding!!) {
        buttonLogin.isEnabled =
            etEmail.text.toString().isValidEmail() && etPassword.text.toString().length >= 5
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

}