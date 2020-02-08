package com.bosqueoeste.ualapp.presentation.list

import com.bosqueoeste.ualapp.presentation.base.BaseContract

interface MealListContract {
    interface View : BaseContract.View {
        fun showMeals(meals: List<ItemMeal>)
        fun goToMealDetail(mealId: String)
    }
    interface Presenter<View>:BaseContract.Presenter<View>{
        fun updateMealList(searchQuery:String="")
        fun selectMealItem(itemMeal: ItemMeal)
    }
}