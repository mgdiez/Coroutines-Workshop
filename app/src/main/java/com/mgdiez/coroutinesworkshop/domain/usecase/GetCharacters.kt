package com.mgdiez.coroutinesworkshop.domain.usecase

import com.mgdiez.coroutinesworkshop.domain.BaseUseCase
import com.mgdiez.coroutinesworkshop.domain.Either
import com.mgdiez.coroutinesworkshop.domain.Failure
import com.mgdiez.coroutinesworkshop.domain.model.CharacterBo
import com.mgdiez.coroutinesworkshop.domain.repository.CharactersRepository

class GetCharacters(
    private val charactersRepository: CharactersRepository
) : BaseUseCase<List<CharacterBo>, GetCharacters.Params>() {

    override suspend fun run(params: Params): Either<Failure, List<CharacterBo>> {
        return try {
            val characters = charactersRepository.getCharacters(params.page)
            Either.Right(characters)
        } catch (exp: Exception) {
            Either.Left(Failure.Error(exp))
        }
    }

    data class Params(val page: Int)
}
