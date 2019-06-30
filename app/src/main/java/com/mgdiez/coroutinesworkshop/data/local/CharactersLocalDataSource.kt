package com.mgdiez.coroutinesworkshop.data.local

import com.mgdiez.coroutinesworkshop.data.CharactersLocalSource
import com.mgdiez.coroutinesworkshop.data.local.database.CharactersDatabase
import com.mgdiez.coroutinesworkshop.data.local.database.CharactersDatabaseDao
import com.mgdiez.coroutinesworkshop.data.local.entity.CharactersEntityMapper
import com.mgdiez.coroutinesworkshop.domain.model.CharacterBo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CharactersLocalDataSource(
    private val charactersDatabase: CharactersDatabase,
    private val charactersEntityMapper: CharactersEntityMapper
) : CharactersLocalSource {

    private val charactersDao: CharactersDatabaseDao by lazy {
        charactersDatabase.charactersDatabaseDao()
    }

    override suspend fun getCharacters(page: Int): List<CharacterBo> =
        charactersEntityMapper.toBo(charactersDao.getCharacters(page))

    override suspend fun getCharacterById(id: Int): CharacterBo =
        charactersEntityMapper.toBo(charactersDao.getCharacterById(id))

    override suspend fun saveCharacters(characters: List<CharacterBo>, page: Int) =
        withContext(Dispatchers.IO) {
            charactersDao.saveCharacters(charactersEntityMapper.toEntity(characters, page))
        }
}
