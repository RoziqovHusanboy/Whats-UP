package com.example.data.repo

import com.example.data.local.settings.SettingsStorage
import com.example.domain.repo.SettingsRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class SettingsRepositoryImpl(
    private val settingsStorage: SettingsStorage
):SettingsRepository {
    override fun onboarded():Completable = settingsStorage
        .onboarded()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

    override fun getOnboarded(): Single<Boolean>  = settingsStorage
        .getOnboarded()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}