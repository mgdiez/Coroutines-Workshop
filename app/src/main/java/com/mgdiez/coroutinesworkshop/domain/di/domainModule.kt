package com.mgdiez.coroutinesworkshop.domain.di

import com.mgdiez.coroutinesworkshop.domain.repository.CharactersRepository
import com.mgdiez.coroutinesworkshop.domain.usecase.GetCharacter
import com.mgdiez.coroutinesworkshop.domain.usecase.GetCharacters
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.koin.core.qualifier.named
import org.koin.dsl.module

val domainModule = module {
    factory {
        GetCharacters(
            get(named("subscribeOn")),
            get(named("observeOn")),
            get()
        )
    }
    factory {
        GetCharacter(
            get(named("subscribeOn")),
            get(named("observeOn")),
            get()
        )
    }

    single(named("subscribeOn")) { Schedulers.io() }
    single(named("observeOn")) { AndroidSchedulers.mainThread() }
    single { CharactersRepository(get(), get()) }
}
