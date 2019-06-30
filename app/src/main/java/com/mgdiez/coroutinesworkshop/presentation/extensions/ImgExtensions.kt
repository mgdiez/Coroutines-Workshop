package com.mgdiez.coroutinesworkshop.presentation.extensions

import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.mgdiez.coroutinesworkshop.R
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

fun ImageView.load(url: String) =
    Picasso.get().load(url).placeholder(R.drawable.rickmorty).error(R.drawable.rickmorty).into(this)

fun ImageView.loadWithTransition(url: String, activity: AppCompatActivity) =
    Picasso.get()
        .load(url)
        .noFade()
        .error(R.drawable.rickmorty)
        .into(this, object : Callback {
            override fun onSuccess() {
                activity.supportStartPostponedEnterTransition()
            }

            override fun onError(e: Exception?) {
                activity.supportStartPostponedEnterTransition()
            }
        })
