package com.mgdiez.coroutinesworkshop.presentation.detail

import com.mgdiez.coroutinesworkshop.domain.usecase.GetCharacter
import com.mgdiez.coroutinesworkshop.presentation.mapper.CharactersViewModelMapper
import io.reactivex.disposables.CompositeDisposable

class CharacterDetailPresenter(
    private val getCharacter: GetCharacter,
    private val mapper: CharactersViewModelMapper
) : CharacterDetailContract.Presenter {

    private var view: CharacterDetailContract.View? = null
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onViewReady(
        view: CharacterDetailContract.View,
        id: Int
    ) {
        this.view = view

        val disposable = getCharacter.execute(
            { view.showCharacter(mapper.transform(it)) },
            { view.finish() }, id
        )

        compositeDisposable.add(disposable)
    }

    override fun onDestroy() {
        view = null
        compositeDisposable.clear()
    }
}
