package com.mgdiez.coroutinesworkshop.data.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mgdiez.coroutinesworkshop.data.local.entity.CharacterEntity

@Dao
abstract class CharactersDatabaseDao {

    @Query(GET_CHARACTERS_BY_PAGE)
    internal abstract suspend fun getCharacters(page: Int): List<CharacterEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    internal abstract suspend fun saveCharacters(characters: List<CharacterEntity>)

    @Query(GET_CHARACTER_BY_ID)
    internal abstract suspend fun getCharacterById(id: Int): CharacterEntity
}
