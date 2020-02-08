package com.bosqueoeste.ualapp.presentation.base

import com.bosqueoeste.ualapp.data.api.UalappApi
import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenter<BaseView : BaseContract.View>(val api: UalappApi) :
   BaseContract.Presenter<BaseView> {

    override var view: BaseView? = null

    protected val disposable = CompositeDisposable()

    override fun onDestroy() {
        disposable.clear()
        view = null
    }
}