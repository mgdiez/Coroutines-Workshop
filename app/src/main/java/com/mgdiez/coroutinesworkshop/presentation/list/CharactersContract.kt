package com.mgdiez.coroutinesworkshop.presentation.list

import com.mgdiez.coroutinesworkshop.presentation.model.CharacterViewModel

interface CharactersContract {

    interface View {
        fun showProgress()
        fun hideProgress()
        fun showItems(items: List<CharacterViewModel>)
        fun showError()
        fun hideError()
    }

    interface Presenter {
        fun onViewReady(view: View)
        fun onBottomReached()
        fun onDestroy()
        fun onRetryClick()
    }
}
