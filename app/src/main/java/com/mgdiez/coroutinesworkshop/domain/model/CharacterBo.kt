package com.mgdiez.coroutinesworkshop.domain.model

data class CharacterBo(
    val id: Int,
    val gender: String,
    val image: String,
    val name: String,
    val species: String,
    val status: String,
    val lastLocation: String,
    val origin: String,
    val offline: Boolean
)
