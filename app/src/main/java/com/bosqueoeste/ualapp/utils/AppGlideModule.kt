package com.bosqueoeste.ualapp.utils

import android.widget.ImageView
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule

@GlideModule
class AppGlideModule : AppGlideModule()

fun ImageView.loadUrl(url: String, placeHolder: Int? = null) {
    GlideApp.with(this.context)
        .load(url)
        .apply {
            placeHolder?.let {
                placeholder(placeHolder)
                error(placeHolder)
            }
        }
        .into(this)
}