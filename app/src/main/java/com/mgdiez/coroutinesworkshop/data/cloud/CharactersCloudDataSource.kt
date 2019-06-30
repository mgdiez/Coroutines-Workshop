package com.mgdiez.coroutinesworkshop.data.cloud

import com.mgdiez.coroutinesworkshop.data.CharactersDataSource
import com.mgdiez.coroutinesworkshop.data.mapper.CharactersDtoMapper
import com.mgdiez.coroutinesworkshop.domain.model.CharacterBo
import io.reactivex.Single

class CharactersCloudDataSource(
    private val charactersApi: CharactersApi,
    private val charactersDtoMapper: CharactersDtoMapper
) : CharactersDataSource {

    override fun getCharacters(page: Int): Single<List<CharacterBo>> =
        charactersApi.getCharacters(page).map { charactersDtoMapper.toBo(it) }

    override fun getCharacterById(id: Int): Single<CharacterBo> =
        charactersApi.getCharacterById(id).map { charactersDtoMapper.toBo(it) }
}
