package com.bosqueoeste.ualapp.presentation.base

interface BaseContract {
    interface View{
        fun showLoaderView()
        fun hideLoaderView()
    }
    interface Presenter<View> {
        var view: View?
        fun onDestroy()
    }
}