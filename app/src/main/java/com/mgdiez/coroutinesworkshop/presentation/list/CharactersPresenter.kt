package com.mgdiez.coroutinesworkshop.presentation.list

import com.mgdiez.coroutinesworkshop.domain.Failure
import com.mgdiez.coroutinesworkshop.domain.model.CharacterBo
import com.mgdiez.coroutinesworkshop.domain.usecase.GetCharacters
import com.mgdiez.coroutinesworkshop.presentation.BasePresenter
import com.mgdiez.coroutinesworkshop.presentation.mapper.CharactersViewModelMapper
import kotlinx.coroutines.cancel

class CharactersPresenter(
    private val getCharacters: GetCharacters,
    private val charactersMapper: CharactersViewModelMapper
) : BasePresenter(), CharactersContract.Presenter {

    private var isLoading: Boolean = false
    private var page: Int = 1
    private var view: CharactersContract.View? = null

    override fun onViewReady(view: CharactersContract.View) {
        this.view = view
        getCharacters()
    }

    private fun getCharacters() {
        if (!isLoading) {
            isLoading = true
            getCharacters.invoke(this, GetCharacters.Params(page))
            {
                it.either(::handleError, ::handleSuccess)
            }
        }
    }

    private fun handleSuccess(characters: List<CharacterBo>) {
        view?.hideProgress()
        page++
        view?.showItems(charactersMapper.transform(characters))
        isLoading = false
    }

    private fun handleError(failure: Failure) {
        view?.hideProgress()
        view?.showError()
        isLoading = false
    }

    override fun onBottomReached() {
        getCharacters()
    }

    override fun onRetryClick() {
        view?.hideError()
        view?.showProgress()
        onBottomReached()
    }

    override fun onDestroy() {
        view = null
        coroutineContext.cancel()
    }

    override fun onGenericError(throwable: Throwable) {
        view?.showError()
    }
}
