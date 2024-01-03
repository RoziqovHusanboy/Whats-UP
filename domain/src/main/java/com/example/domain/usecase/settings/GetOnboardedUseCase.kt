package com.example.domain.usecase.settings

import com.example.domain.repo.SettingsRepository

class GetOnboardedUseCase(
    private val repository: SettingsRepository
) {
    operator fun invoke() = repository.getOnboarded()
}