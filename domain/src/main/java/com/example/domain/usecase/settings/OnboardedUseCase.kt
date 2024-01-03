package com.example.domain.usecase.settings

import com.example.domain.repo.SettingsRepository

class OnboardedUseCase(
    private val repository: SettingsRepository
) {

    operator fun invoke()=repository.onboarded()

}