package com.crisnavarro.androidfirebasesample.ui.passwordrecover

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.crisnavarro.androidfirebasesample.R
import com.crisnavarro.androidfirebasesample.databinding.RecoverPasswordFragmentBinding

class RecoverPasswordFragment: Fragment(R.layout.recover_password_fragment) {

    private val viewModel: RecoverPasswordViewModel by viewModels()
    private var binding: RecoverPasswordFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = RecoverPasswordFragmentBinding.inflate(layoutInflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

}