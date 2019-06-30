package com.mgdiez.coroutinesworkshop.data.cloud.dto

data class CharacterDto(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: LocationDto,
    val name: String,
    val origin: OriginDto,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)

data class OriginDto(
    val name: String,
    val url: String
)

data class LocationDto(
    val name: String,
    val url: String
)
