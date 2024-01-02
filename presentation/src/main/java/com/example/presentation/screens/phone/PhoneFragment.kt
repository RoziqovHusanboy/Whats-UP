package com.example.presentation.screens.phone

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.domain.model.User
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentPhoneBinding
import com.example.presentation.screens.phone.PhoneViewModel.Effect
import org.koin.androidx.viewmodel.ext.android.viewModel

class PhoneFragment:BaseFragment<FragmentPhoneBinding>(FragmentPhoneBinding::inflate) {

    private val viewModel: PhoneViewModel by viewModel()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.state.observe(::renderUser){it.user}
        viewModel.effects.doOnNext (::handleEffects)

    }

    private fun renderUser(user: User?) {

    }

    private fun handleEffects(effect: Effect){

    }

}