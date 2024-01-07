package com.example.presentation.screens.onboarding

import android.os.Bundle
import android.view.View
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentOnboardingBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class OnboardingFragment :BaseFragment<FragmentOnboardingBinding>(FragmentOnboardingBinding::inflate) {
    private val viewModel:OnboardingViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()

    }

    private fun initUI() = with(binding) {
        next.setOnClickListener {
            viewModel.processInput(OnboardingViewModel.Input.Onboarded)
        }
    }

}