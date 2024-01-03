package com.example.whatsup.di

import com.example.data.local.settings.SettingsRealm
import com.example.data.local.settings.SettingsStorage
import com.example.data.local.settings.SettingsStorageImpl
import com.example.data.local.user.UserStorage
import com.example.data.local.user.UserStorageImpl
import com.example.data.remote.auth.AuthFirebase
import com.example.data.remote.auth.AuthFirebaseImpl
import com.example.data.repo.AuthRepositoryImpl
import com.example.data.repo.SettingsRepositoryImpl
import com.example.domain.repo.AuthRepository
import com.example.domain.repo.SettingsRepository
import com.example.domain.usecase.auth.SendSmsCodeUseCase
import com.example.domain.usecase.settings.GetOnboardedUseCase
import com.example.domain.usecase.settings.OnboardedUseCase
import com.example.presentation.screens.main.MainViewModel
import com.example.presentation.screens.phone.PhoneViewModel
import com.github.terrakok.cicerone.Cicerone
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private val cicerone = Cicerone.create()
val config = RealmConfiguration.Builder(schema = setOf(SettingsRealm::class))
    .build()

val appModule = module {
    single { cicerone.router }
    single { cicerone.getNavigatorHolder() }
    single { Realm.open(config) }
}

val repositoryModule = module {
    single<AuthRepository> { AuthRepositoryImpl(get()) }
    single<SettingsRepository> { SettingsRepositoryImpl(get()) }
}

val useCaseModule = module {
    single<SendSmsCodeUseCase> { SendSmsCodeUseCase(get()) }
    single { GetOnboardedUseCase(get()) }
    single { OnboardedUseCase(get()) }

}

val localModule = module {
    single<UserStorage> { UserStorageImpl() }
    single<SettingsStorage> { SettingsStorageImpl(get()) }

}

val remoteModule = module {
    single<AuthFirebase> { AuthFirebaseImpl() }

}

val viewModelModule = module {
    viewModel { PhoneViewModel(get()) }
    viewModel { MainViewModel(get()) }
}