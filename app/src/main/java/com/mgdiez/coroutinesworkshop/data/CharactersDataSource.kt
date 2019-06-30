package com.mgdiez.coroutinesworkshop.data

import com.mgdiez.coroutinesworkshop.domain.model.CharacterBo

interface CharactersDataSource {

    suspend fun getCharacters(page: Int): List<CharacterBo>

    suspend fun getCharacterById(id: Int): CharacterBo
}

interface CharactersLocalSource : CharactersDataSource {

    suspend fun saveCharacters(characters: List<CharacterBo>, page: Int)
}
