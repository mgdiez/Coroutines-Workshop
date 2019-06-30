package com.mgdiez.coroutinesworkshop.domain.repository

import com.mgdiez.coroutinesworkshop.data.CharactersDataSource
import com.mgdiez.coroutinesworkshop.data.CharactersLocalSource
import com.mgdiez.coroutinesworkshop.domain.Either
import com.mgdiez.coroutinesworkshop.domain.Failure
import com.mgdiez.coroutinesworkshop.domain.flatMap
import com.mgdiez.coroutinesworkshop.domain.map
import com.mgdiez.coroutinesworkshop.domain.model.CharacterBo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class CharactersRepository(
    private val charactersDataSource: CharactersDataSource,
    private val charactersLocalDataSource: CharactersLocalSource
) {

    suspend fun getCharacters(page: Int): List<CharacterBo> {
        var characters = charactersLocalDataSource.getCharacters(page)

        if (characters.isEmpty()) {
            characters = charactersDataSource.getCharacters(page)
            charactersLocalDataSource.saveCharacters(characters, page)
        }

        return characters
    }

    suspend fun getCharacter(id: Int): CharacterBo = charactersLocalDataSource.getCharacterById(id)
}
