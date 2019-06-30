package com.mgdiez.coroutinesworkshop.presentation.list

import com.mgdiez.coroutinesworkshop.domain.usecase.GetCharacters
import com.mgdiez.coroutinesworkshop.presentation.mapper.CharactersViewModelMapper
import io.reactivex.disposables.CompositeDisposable

class CharactersPresenter(
    private val getCharacters: GetCharacters,
    private val charactersMapper: CharactersViewModelMapper
) : CharactersContract.Presenter {

    private var isLoading: Boolean = false
    private var page: Int = 1
    private var view: CharactersContract.View? = null

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onViewReady(view: CharactersContract.View) {
        this.view = view
        getCharacters()
    }

    private fun getCharacters() {
        if (!isLoading) {
            isLoading = true
            val disposable =
                getCharacters.execute(
                    {
                        view?.hideProgress()
                        view?.showItems(charactersMapper.transform(it))
                        page++
                        isLoading = false
                    }, {
                        view?.hideProgress()
                        view?.showError()
                        isLoading = false
                    }, page
                )
            compositeDisposable.add(disposable)
        }
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
        compositeDisposable.clear()
    }
}
