package com.mgdiez.coroutinesworkshop.presentation.detail

import com.mgdiez.coroutinesworkshop.domain.Failure
import com.mgdiez.coroutinesworkshop.domain.model.CharacterBo
import com.mgdiez.coroutinesworkshop.domain.usecase.GetCharacter
import com.mgdiez.coroutinesworkshop.presentation.BasePresenter
import com.mgdiez.coroutinesworkshop.presentation.mapper.CharactersViewModelMapper
import kotlinx.coroutines.cancel

class CharacterDetailPresenter(
    private val getCharacter: GetCharacter,
    private val mapper: CharactersViewModelMapper
) : BasePresenter(), CharacterDetailContract.Presenter {

    private var view: CharacterDetailContract.View? = null

    override fun onViewReady(
        view: CharacterDetailContract.View,
        id: Int
    ) {
        this.view = view

        getCharacter.invoke(this, GetCharacter.Params(id)) {
            it.either(::handleError, ::handleSuccess)
        }
    }

    private fun handleSuccess(characterBo: CharacterBo) {
        view?.showCharacter(mapper.transform(characterBo))
    }

    private fun handleError(failure: Failure) {
        view?.finish()
    }

    override fun onDestroy() {
        view = null
        coroutineContext.cancel()
    }

    override fun onGenericError(throwable: Throwable) {
        view?.finish()
    }
}
