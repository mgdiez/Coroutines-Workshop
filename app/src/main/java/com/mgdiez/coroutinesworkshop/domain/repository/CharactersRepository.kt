package com.mgdiez.coroutinesworkshop.domain.repository

import com.mgdiez.coroutinesworkshop.data.CharactersDataSource
import com.mgdiez.coroutinesworkshop.data.CharactersLocalSource
import com.mgdiez.coroutinesworkshop.domain.model.CharacterBo
import io.reactivex.Single

class CharactersRepository(
    private val charactersDataSource: CharactersDataSource,
    private val charactersLocalDataSource: CharactersLocalSource
) {

    fun getCharacters(page: Int): Single<List<CharacterBo>> =
        Single.concat(
            charactersLocalDataSource.getCharacters(page),
            charactersDataSource.getCharacters(page).flatMap {
                charactersLocalDataSource.saveCharacters(
                    it,
                    page
                ).onErrorComplete().andThen(Single.just(it))
            }
        ).filter { it.isNotEmpty() }.firstOrError()

    fun getCharacter(id: Int): Single<CharacterBo> =
        Single.concat(
            charactersLocalDataSource.getCharacterById(id),
            charactersDataSource.getCharacterById(id)
        ).firstOrError()
}
