package com.example.presentation.navigation

import com.example.presentation.screens.onboarding.OnboardingFragment
import com.example.presentation.screens.phone.PhoneFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun PhoneScreen() = FragmentScreen{PhoneFragment()}
    fun OnboardingScreen() = FragmentScreen{OnboardingFragment()}

}