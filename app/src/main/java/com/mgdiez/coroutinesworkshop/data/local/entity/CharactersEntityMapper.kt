package com.mgdiez.coroutinesworkshop.data.local.entity

import com.mgdiez.coroutinesworkshop.domain.model.CharacterBo

class CharactersEntityMapper {

    fun toBo(entities: List<CharacterEntity>): List<CharacterBo> = entities.map { toBo(it) }

    fun toBo(entity: CharacterEntity): CharacterBo =
        CharacterBo(
            entity.id,
            entity.gender,
            entity.image,
            entity.name,
            entity.specie,
            entity.status,
            entity.location,
            entity.origin,
            true
        )

    fun toEntity(characters: List<CharacterBo>, page: Int): List<CharacterEntity> =
        characters.map { toEntity(it, page) }

    private fun toEntity(character: CharacterBo, page: Int): CharacterEntity =
        CharacterEntity(
            character.id,
            page,
            character.gender,
            character.image,
            character.name,
            character.species,
            character.status,
            character.lastLocation,
            character.origin
        )
}
