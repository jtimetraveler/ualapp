package com.bosqueoeste.ualapp.presentation.base

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity(), BaseContract.View {

    override fun showLoaderView() {
    }

    override fun hideLoaderView() {
    }
}