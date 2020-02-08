package com.bosqueoeste.ualapp.presentation.list

import com.bosqueoeste.ualapp.presentation.base.BaseContract

interface MealListContract {
    interface View:BaseContract.View
    interface Presenter<View>:BaseContract.Presenter<View>{
        fun updateMealList(searchQuery:String="")
    }
}