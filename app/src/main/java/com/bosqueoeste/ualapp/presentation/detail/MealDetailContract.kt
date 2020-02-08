package com.bosqueoeste.ualapp.presentation.detail

import com.bosqueoeste.ualapp.presentation.base.BaseContract

interface MealDetailContract {
    interface View : BaseContract.View {
        fun showMealDetail(meals: MealDetailUseCase)
    }

    interface Presenter<View> : BaseContract.Presenter<View> {
        fun getMealById(idMeal: String)
    }
}