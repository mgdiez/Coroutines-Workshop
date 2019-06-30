package com.mgdiez.coroutinesworkshop.data.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mgdiez.coroutinesworkshop.data.local.entity.CharacterEntity
import io.reactivex.Completable
import io.reactivex.Single

@Dao
abstract class CharactersDatabaseDao {

    @Query(GET_CHARACTERS_BY_PAGE)
    internal abstract fun getCharacters(page: Int): Single<List<CharacterEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    internal abstract fun saveCharacters(characters: List<CharacterEntity>): Completable

    @Query(GET_CHARACTER_BY_ID)
    internal abstract fun getCharacterById(id: Int): Single<CharacterEntity>
}
