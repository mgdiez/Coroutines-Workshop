package com.mgdiez.coroutinesworkshop.data.cloud

import com.mgdiez.coroutinesworkshop.data.CharactersDataSource
import com.mgdiez.coroutinesworkshop.data.mapper.CharactersDtoMapper
import com.mgdiez.coroutinesworkshop.domain.model.CharacterBo

class CharactersCloudDataSource(
    private val charactersApi: CharactersApi,
    private val charactersDtoMapper: CharactersDtoMapper
) : CharactersDataSource {

    override suspend fun getCharacters(page: Int): List<CharacterBo> =
        charactersDtoMapper.toBo(charactersApi.getCharacters(page))

    override suspend fun getCharacterById(id: Int): CharacterBo =
        charactersDtoMapper.toBo(charactersApi.getCharacterById(id))
}
