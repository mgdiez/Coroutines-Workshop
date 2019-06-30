package com.mgdiez.coroutinesworkshop.data.cloud.dto

data class CharactersDto(
    val info: InfoDto,
    val results: List<CharacterDto>
)

data class InfoDto(
    val count: Int,
    val next: String,
    val pages: Int,
    val prev: String
)
