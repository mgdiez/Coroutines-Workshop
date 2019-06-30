package com.mgdiez.coroutinesworkshop.domain.di

import com.mgdiez.coroutinesworkshop.domain.repository.CharactersRepository
import com.mgdiez.coroutinesworkshop.domain.usecase.GetCharacter
import com.mgdiez.coroutinesworkshop.domain.usecase.GetCharacters
import org.koin.dsl.module

val domainModule = module {
    factory { GetCharacters(get()) }
    factory { GetCharacter(get()) }

    single { CharactersRepository(get(), get()) }
}
