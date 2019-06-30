package com.mgdiez.coroutinesworkshop

import android.app.Application
import com.mgdiez.coroutinesworkshop.data.di.dataModule
import com.mgdiez.coroutinesworkshop.domain.di.domainModule
import com.mgdiez.coroutinesworkshop.presentation.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class RickAndMortyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@RickAndMortyApp)
            modules(listOf(appModule, domainModule, dataModule))
        }
    }
}
