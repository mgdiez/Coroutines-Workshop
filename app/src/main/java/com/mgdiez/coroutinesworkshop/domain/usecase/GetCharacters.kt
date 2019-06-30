package com.mgdiez.coroutinesworkshop.domain.usecase

import com.mgdiez.coroutinesworkshop.domain.repository.CharactersRepository
import com.mgdiez.coroutinesworkshop.domain.model.CharacterBo
import io.reactivex.Scheduler
import io.reactivex.disposables.Disposable

class GetCharacters(
    private val subscribeOn: Scheduler,
    private val observeOn: Scheduler,
    private val charactersRepository: CharactersRepository
) {

    fun execute(
        onSuccess: (List<CharacterBo>) -> Unit,
        onError: (Throwable) -> Unit,
        page: Int
    ): Disposable = charactersRepository
        .getCharacters(page)
        .subscribeOn(subscribeOn)
        .observeOn(observeOn)
        .subscribe(
            onSuccess,
            onError
        )
}
