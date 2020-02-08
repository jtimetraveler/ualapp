package com.bosqueoeste.ualapp.presentation.list

import android.util.Log
import com.bosqueoeste.ualapp.data.api.UalappApi
import com.bosqueoeste.ualapp.presentation.base.BasePresenter
import com.bosqueoeste.ualapp.utils.subscribeOnAndroid
import javax.inject.Inject

class MealListPresenter @Inject constructor(api: UalappApi) :
    BasePresenter<MealListContract.View>(api), MealListContract.Presenter<MealListContract.View> {


    override fun updateMealList(searchQuery:String) {
        disposable.add(api.getMeals(searchQuery).subscribeOnAndroid().subscribe({
            Log.d("API", it.meals.joinToString())
        }, { Log.e("API", it.message) }))
    }
}