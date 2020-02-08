package com.bosqueoeste.ualapp.presentation.detail

import com.bosqueoeste.ualapp.data.api.UalappApi
import com.bosqueoeste.ualapp.presentation.base.BasePresenter
import javax.inject.Inject

class MealDetailPresenter @Inject constructor(api: UalappApi) :
    BasePresenter<MealDetailContract.View>(api),
    MealDetailContract.Presenter<MealDetailContract.View> {

    override fun getMealById(idMeal: String) {

    }

}