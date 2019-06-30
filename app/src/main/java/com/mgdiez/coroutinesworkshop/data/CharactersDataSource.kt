package com.mgdiez.coroutinesworkshop.data

import com.mgdiez.coroutinesworkshop.domain.model.CharacterBo
import io.reactivex.Completable
import io.reactivex.Single

interface CharactersDataSource {

    fun getCharacters(page: Int): Single<List<CharacterBo>>

    fun getCharacterById(id: Int): Single<CharacterBo>
}

interface CharactersLocalSource : CharactersDataSource {

    fun saveCharacters(characters: List<CharacterBo>, page: Int): Completable
}
