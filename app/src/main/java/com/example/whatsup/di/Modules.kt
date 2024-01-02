package com.example.whatsup.di

import com.example.data.local.user.UserStorage
import com.example.data.local.user.UserStorageImpl
import com.example.data.remote.auth.AuthFirebase
import com.example.data.remote.auth.AuthFirebaseImpl
import com.example.data.repo.AuthRepositoryImpl
import com.example.domain.repo.AuthRepository
import com.example.domain.usecase.auth.SendSmsCodeUseCase
import com.example.presentation.screens.phone.PhoneViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val repositoryModule = module {
    single<AuthRepository> {AuthRepositoryImpl(get ())}
}

val useCaseModule = module {
    single<SendSmsCodeUseCase> { SendSmsCodeUseCase(get ()) }
}

val localModule = module {
    single<UserStorage> { UserStorageImpl() }
}

val remoteModule = module {
    single<AuthFirebase> { AuthFirebaseImpl() }

}

val viewModelModule = module{
    viewModel { PhoneViewModel(get()) }
}