package com.mgdiez.coroutinesworkshop.presentation.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.mgdiez.coroutinesworkshop.R
import com.mgdiez.coroutinesworkshop.presentation.model.CharacterViewModel
import com.mgdiez.coroutinesworkshop.presentation.model.Gender
import com.mgdiez.coroutinesworkshop.presentation.model.Status
import com.mgdiez.coroutinesworkshop.presentation.extensions.empty
import com.mgdiez.coroutinesworkshop.presentation.extensions.loadWithTransition
import kotlinx.android.synthetic.main.activity_detail.*
import org.koin.android.ext.android.inject

class CharacterDetailActivity : AppCompatActivity(), CharacterDetailContract.View {

    companion object {

        private const val PARAM_ID = "PARAM_ID"
        private const val PARAM_URL = "PARAM_URL"

        fun getCallingIntent(context: Context, id: Int, url: String): Intent =
            Intent(context, CharacterDetailActivity::class.java).apply {
                putExtra(PARAM_ID, id)
                putExtra(PARAM_URL, url)
            }
    }

    private val presenter: CharacterDetailContract.Presenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        initViews()
        initToolbar()
        window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        presenter.onViewReady(this, extractId())
    }

    private fun initViews() {
        ivCharacter.transitionName = extractId().toString()
        ivCharacter.loadWithTransition(extractImageUrl(), this@CharacterDetailActivity)
    }

    private fun initToolbar() {
        toolbar.setNavigationIcon(R.drawable.icv_back_chevron)
        toolbar.setNavigationOnClickListener { onBackPressed() }
    }

    private fun extractId(): Int = intent.extras?.getInt(PARAM_ID) ?: 0

    private fun extractImageUrl(): String = intent.extras?.getString(PARAM_URL) ?: String.empty()

    override fun showCharacter(characterViewModel: CharacterViewModel) {
        tvName.text = characterViewModel.name
        tvStatus.text = when (characterViewModel.status) {
            Status.Alive -> getString(R.string.alive_symbol)
            Status.Dead -> getString(R.string.dead_symbol)
            Status.Unknown -> getString(R.string.unknown_symbol)
        }
        tvLastLocation.text = characterViewModel.lastLocation
        tvGender.text = when (characterViewModel.gender) {
            Gender.Female -> getString(R.string.male_symbol)
            Gender.Male -> getString(R.string.female_symbol)
            Gender.Genderless -> getString(R.string.genderless_symbol)
            Gender.Unknown -> getString(R.string.unknown_symbol)
        }
        tvOrigin.text = characterViewModel.origin
        tvSpecie.text = characterViewModel.species
    }
}
