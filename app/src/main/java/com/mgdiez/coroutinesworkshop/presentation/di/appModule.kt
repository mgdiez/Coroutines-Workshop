package com.mgdiez.coroutinesworkshop.presentation.di

import com.mgdiez.coroutinesworkshop.presentation.detail.CharacterDetailContract
import com.mgdiez.coroutinesworkshop.presentation.detail.CharacterDetailPresenter
import com.mgdiez.coroutinesworkshop.presentation.list.CharactersContract
import com.mgdiez.coroutinesworkshop.presentation.list.CharactersPresenter
import com.mgdiez.coroutinesworkshop.presentation.mapper.CharactersViewModelMapper
import com.mgdiez.coroutinesworkshop.presentation.navigator.Navigator
import org.koin.dsl.module

val appModule = module {
    factory<CharactersContract.Presenter> { CharactersPresenter(get(), get()) }
    factory<CharacterDetailContract.Presenter> { CharacterDetailPresenter(get(), get()) }
    single { Navigator() }
    single { CharactersViewModelMapper() }
}
