package com.mgdiez.coroutinesworkshop.domain.usecase

import com.mgdiez.coroutinesworkshop.domain.BaseUseCase
import com.mgdiez.coroutinesworkshop.domain.Either
import com.mgdiez.coroutinesworkshop.domain.Failure
import com.mgdiez.coroutinesworkshop.domain.model.CharacterBo
import com.mgdiez.coroutinesworkshop.domain.repository.CharactersRepository

class GetCharacter(
    private val charactersRepository: CharactersRepository
) : BaseUseCase<CharacterBo, GetCharacter.Params>() {

    override suspend fun run(params: Params): Either<Failure, CharacterBo> {
        return try {
            val character = charactersRepository.getCharacter(params.id)
            Either.Right(character)
        } catch (exp: Exception) {
            Either.Left(Failure.Error(exp))
        }
    }

    data class Params(val id: Int)
}
