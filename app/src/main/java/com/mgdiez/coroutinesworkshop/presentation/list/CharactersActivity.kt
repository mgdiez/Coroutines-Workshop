package com.mgdiez.coroutinesworkshop.presentation.list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mgdiez.coroutinesworkshop.R
import com.mgdiez.coroutinesworkshop.presentation.extensions.gone
import com.mgdiez.coroutinesworkshop.presentation.extensions.visible
import com.mgdiez.coroutinesworkshop.presentation.model.CharacterViewModel
import com.mgdiez.coroutinesworkshop.presentation.navigator.Navigator
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class CharactersActivity : AppCompatActivity(), CharactersContract.View {

    private val presenter: CharactersContract.Presenter by inject()
    private val navigator: Navigator by inject()
    private val adapter: CharactersAdapter =
        CharactersAdapter { item, imageView -> navigator.navigateToDetail(this, item.id, item.image, imageView) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        presenter.onViewReady(this)
    }

    private fun initViews() {
        tvError.setOnClickListener { presenter.onRetryClick() }

        val gridLayoutManager =
            GridLayoutManager(this@CharactersActivity, resources.getInteger(R.integer.count_columns))
        recyclerView.adapter = adapter
        recyclerView.layoutManager = gridLayoutManager
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                if (gridLayoutManager.findLastCompletelyVisibleItemPosition() == gridLayoutManager.itemCount - 1)
                    presenter.onBottomReached()
                super.onScrollStateChanged(recyclerView, newState)
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun showProgress() {
        loadingGroup.visible()
    }

    override fun hideProgress() {
        loadingGroup.gone()
    }

    override fun showItems(items: List<CharacterViewModel>) {
        recyclerView.visible()
        adapter.addItems(items)
    }

    override fun showError() {
        errorGroup.visible()
    }

    override fun hideError() {
        errorGroup.gone()
    }
}
