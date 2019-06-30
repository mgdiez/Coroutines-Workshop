package com.mgdiez.coroutinesworkshop.presentation.mapper

import com.mgdiez.coroutinesworkshop.domain.model.CharacterBo
import com.mgdiez.coroutinesworkshop.presentation.model.CharacterViewModel
import com.mgdiez.coroutinesworkshop.presentation.model.Gender
import com.mgdiez.coroutinesworkshop.presentation.model.Network
import com.mgdiez.coroutinesworkshop.presentation.model.Status

class CharactersViewModelMapper {

    private companion object {

        private const val MALE = "Male"
        private const val FEMALE = "Female"
        private const val GENDERLESS = "Genderless"
        private const val ALIVE = "Alive"
        private const val DEAD = "Dead"
    }

    fun transform(characters: List<CharacterBo>): List<CharacterViewModel> =
        characters.map { transform(it) }.toList()

    fun transform(it: CharacterBo): CharacterViewModel {
        return CharacterViewModel(
            it.id,
            mapGender(it.gender),
            it.image,
            it.name,
            it.species,
            mapStatus(it.status),
            it.lastLocation,
            it.origin,
            mapNetwork(it.offline)
        )
    }

    private fun mapStatus(status: String): Status {
        return when (status) {
            ALIVE -> Status.Alive
            DEAD -> Status.Dead
            else -> Status.Unknown
        }
    }

    private fun mapGender(gender: String): Gender {
        return when (gender) {
            MALE -> Gender.Male
            FEMALE -> Gender.Female
            GENDERLESS -> Gender.Genderless
            else -> Gender.Unknown
        }
    }

    private fun mapNetwork(offline: Boolean) = if (offline) Network.Offline else Network.Online

}
