package com.mgdiez.coroutinesworkshop.data.local.database

import com.mgdiez.coroutinesworkshop.data.local.entity.CharacterEntity

internal const val GET_CHARACTERS_BY_PAGE =
    "SELECT * FROM ${CharacterEntity.CHARACTERS_TABLE} WHERE ${CharacterEntity.COLUMN_PAGE} LIKE :page"

internal const val GET_CHARACTER_BY_ID =
    "SELECT * FROM ${CharacterEntity.CHARACTERS_TABLE} WHERE ${CharacterEntity.COLUMN_ID} LIKE :id"
