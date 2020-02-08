package com.bosqueoeste.ualapp.presentation.detail

import com.bosqueoeste.ualapp.presentation.base.BaseContract
import com.bosqueoeste.ualapp.presentation.list.MealUseCase

interface MealDetailContract {
    interface View : BaseContract.View {
        fun showMealDetail(meals: MealUseCase)
    }

    interface Presenter<View> : BaseContract.Presenter<View> {
        fun getMealById(idMeal: String)
    }
}