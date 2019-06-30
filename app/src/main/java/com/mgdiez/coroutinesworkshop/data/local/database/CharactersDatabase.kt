package com.mgdiez.coroutinesworkshop.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mgdiez.coroutinesworkshop.data.local.entity.CharacterEntity

@Database(
    entities = [CharacterEntity::class],
    version = CHARACTERS_DB_VERSION
)
abstract class CharactersDatabase : RoomDatabase() {

    abstract fun charactersDatabaseDao(): CharactersDatabaseDao
}
