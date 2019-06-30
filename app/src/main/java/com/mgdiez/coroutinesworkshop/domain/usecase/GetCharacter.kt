package com.mgdiez.coroutinesworkshop.domain.usecase

import com.mgdiez.coroutinesworkshop.domain.repository.CharactersRepository
import com.mgdiez.coroutinesworkshop.domain.model.CharacterBo
import io.reactivex.Scheduler
import io.reactivex.disposables.Disposable

class GetCharacter(
    private val subscribeOn: Scheduler,
    private val observeOn: Scheduler,
    private val charactersRepository: CharactersRepository
) {

    fun execute(
        onSuccess: (CharacterBo) -> Unit,
        onError: (Throwable) -> Unit,
        id: Int
    ): Disposable = charactersRepository
        .getCharacter(id)
        .subscribeOn(subscribeOn)
        .observeOn(observeOn)
        .subscribe(
            onSuccess,
            onError
        )
}
