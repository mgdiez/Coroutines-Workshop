package com.mgdiez.coroutinesworkshop.data.mapper

import com.mgdiez.coroutinesworkshop.data.cloud.dto.CharacterDto
import com.mgdiez.coroutinesworkshop.data.cloud.dto.CharactersDto
import com.mgdiez.coroutinesworkshop.domain.model.CharacterBo

class CharactersDtoMapper {

    fun toBo(dto: CharactersDto): List<CharacterBo> = dto.results.map { toBo(it) }

    fun toBo(dto: CharacterDto): CharacterBo =
        CharacterBo(
            dto.id,
            dto.gender,
            dto.image,
            dto.name,
            dto.species,
            dto.status,
            dto.location.name,
            dto.origin.name,
            false
        )
}
