package com.example.presentation.screens.onboarding

import com.example.domain.usecase.settings.OnboardedUseCase
import com.example.presentation.base.BaseViewModel
import com.example.presentation.navigation.Screens.PhoneScreen
import com.example.presentation.screens.onboarding.OnboardingViewModel.*
import com.github.terrakok.cicerone.Router

class OnboardingViewModel(
    private val onboardedUseCase: OnboardedUseCase,
    private val router: Router
):BaseViewModel<State,Input,Effect>() {

    class State

    sealed class Input{
        object Onboarded:Input()

    }

    class Effect

    override fun getDefaultState() = State()

    override fun processInput(input: Input) {
        when(input){
            Input.Onboarded -> onboarded()
        }
    }

    private fun onboarded() {
        onboardedUseCase().subscribe {
            router.replaceScreen(PhoneScreen())
        }
    }
}