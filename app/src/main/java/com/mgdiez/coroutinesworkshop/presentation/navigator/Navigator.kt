package com.mgdiez.coroutinesworkshop.presentation.navigator

import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.core.view.ViewCompat
import com.mgdiez.coroutinesworkshop.presentation.detail.CharacterDetailActivity

class Navigator {

    fun navigateToDetail(activity: AppCompatActivity, id: Int, url: String, imageView: ImageView) {
        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
            activity,
            imageView,
            ViewCompat.getTransitionName(imageView)!!
        )
        activity.startActivity(CharacterDetailActivity.getCallingIntent(activity, id, url), options.toBundle())
    }
}
