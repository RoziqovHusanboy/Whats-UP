package com.example.presentation.screens.phone

import androidx.lifecycle.ViewModel
import com.example.domain.usecase.auth.SendSmsCodeUseCase

class PhoneViewModel constructor(
    private val sendSmsCodeUseCase: SendSmsCodeUseCase
) :ViewModel() {

}