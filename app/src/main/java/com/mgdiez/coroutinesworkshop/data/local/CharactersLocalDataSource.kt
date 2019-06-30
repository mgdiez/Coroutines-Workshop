package com.mgdiez.coroutinesworkshop.data.local

import com.mgdiez.coroutinesworkshop.data.CharactersLocalSource
import com.mgdiez.coroutinesworkshop.data.local.database.CharactersDatabase
import com.mgdiez.coroutinesworkshop.data.local.database.CharactersDatabaseDao
import com.mgdiez.coroutinesworkshop.data.local.entity.CharactersEntityMapper
import com.mgdiez.coroutinesworkshop.domain.model.CharacterBo
import io.reactivex.Completable
import io.reactivex.Single

class CharactersLocalDataSource(
    private val charactersDatabase: CharactersDatabase,
    private val charactersEntityMapper: CharactersEntityMapper
) : CharactersLocalSource {

    private val charactersDao: CharactersDatabaseDao by lazy {
        charactersDatabase.charactersDatabaseDao()
    }

    override fun getCharacters(page: Int): Single<List<CharacterBo>> =
        charactersDao.getCharacters(page).map { charactersEntityMapper.toBo(it) }

    override fun getCharacterById(id: Int): Single<CharacterBo> =
        charactersDao.getCharacterById(id).map { charactersEntityMapper.toBo(it) }

    override fun saveCharacters(characters: List<CharacterBo>, page: Int): Completable =
        charactersDao.saveCharacters(charactersEntityMapper.toEntity(characters, page))
}
