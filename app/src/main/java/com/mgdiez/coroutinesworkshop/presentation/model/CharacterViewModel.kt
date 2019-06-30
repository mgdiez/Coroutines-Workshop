package com.mgdiez.coroutinesworkshop.presentation.model

data class CharacterViewModel(
    val id: Int,
    val gender: Gender,
    val image: String,
    val name: String,
    val species: String,
    val status: Status,
    val lastLocation: String,
    val origin: String,
    val network: Network
)

sealed class Gender {
    object Female : Gender()
    object Male : Gender()
    object Genderless : Gender()
    object Unknown : Gender()
}

sealed class Status {
    object Alive : Status()
    object Dead : Status()
    object Unknown : Status()
}

sealed class Network {
    object Offline : Network()
    object Online : Network()
}
