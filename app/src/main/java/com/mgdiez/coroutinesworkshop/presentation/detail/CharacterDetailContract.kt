package com.mgdiez.coroutinesworkshop.presentation.detail

import com.mgdiez.coroutinesworkshop.presentation.model.CharacterViewModel

interface CharacterDetailContract {

    interface View {
        fun showCharacter(characterViewModel: CharacterViewModel)
        fun finish()
    }

    interface Presenter {
        fun onViewReady(view: View, id: Int)
        fun onDestroy()
    }
}
