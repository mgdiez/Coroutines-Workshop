package com.mgdiez.coroutinesworkshop.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mgdiez.coroutinesworkshop.data.local.entity.CharacterEntity.Companion.CHARACTERS_TABLE

@Entity(tableName = CHARACTERS_TABLE)
data class CharacterEntity(
    @PrimaryKey
    @ColumnInfo(name = COLUMN_ID) val id: Int,
    @ColumnInfo(name = COLUMN_PAGE) val page: Int,
    @ColumnInfo(name = COLUMN_GENDER) val gender: String,
    @ColumnInfo(name = COLUMN_IMAGE) val image: String,
    @ColumnInfo(name = COLUMN_NAME) val name: String,
    @ColumnInfo(name = COLUMN_SPECIE) val specie: String,
    @ColumnInfo(name = COLUMN_STATUS) val status: String,
    @ColumnInfo(name = COLUMN_LOCATION) val location: String,
    @ColumnInfo(name = COLUMN_ORIGIN) val origin: String
) {

    internal companion object {
        internal const val CHARACTERS_TABLE = "characters_table"
        internal const val COLUMN_ID = "id"
        internal const val COLUMN_PAGE = "page"
        internal const val COLUMN_GENDER = "gender"
        internal const val COLUMN_IMAGE = "image"
        internal const val COLUMN_NAME = "name"
        internal const val COLUMN_SPECIE = "specie"
        internal const val COLUMN_STATUS = "status"
        internal const val COLUMN_LOCATION = "location"
        internal const val COLUMN_ORIGIN = "origin"
    }
}
