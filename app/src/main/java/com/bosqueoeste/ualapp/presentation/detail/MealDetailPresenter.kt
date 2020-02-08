package com.bosqueoeste.ualapp.presentation.detail

import android.util.Log
import com.bosqueoeste.ualapp.data.api.UalappApi
import com.bosqueoeste.ualapp.presentation.base.BasePresenter
import com.bosqueoeste.ualapp.utils.subscribeOnAndroid
import javax.inject.Inject

class MealDetailPresenter @Inject constructor(api: UalappApi) :
    BasePresenter<MealDetailContract.View>(api),
    MealDetailContract.Presenter<MealDetailContract.View> {

    override fun getMealById(idMeal: String) {
        disposable.add(api.getMealById(idMeal).subscribeOnAndroid().map {
            it.meals?.get(0)?.let { MealDetailUseCase(it) }
        }.subscribe({
            it?.let {
                view?.showMealDetail(it)
            }
        }, {
            Log.e("API", it.message)
        }))
    }

}