package com.crisnavarro.androidfirebasesample.ui.signup

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.crisnavarro.androidfirebasesample.R
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
        initObservers()
        initListeners()
    }

    private fun initListeners() = with(binding!!) {

        buttonSignup.setOnClickListener {
            signUp()
        }

    }

    private fun initObservers() {

        viewModel.loginSuccess.observe(viewLifecycleOwner) {
            when (it) {
                true -> {
                    Log.e("SUCCESS", "SUCCESS")
                }
                false -> {
                    Log.e("FAILED", "FAILED")
                }
            }
        }

    }

    private fun signUp() = with(binding!!) {

        val email = etEmail.text.toString()
        val password = etPassword.text.toString()

        viewModel.signUp(email, password)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

}