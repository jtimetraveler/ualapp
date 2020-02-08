package com.bosqueoeste.ualapp.presentation.list

import android.os.Handler
import com.bosqueoeste.ualapp.data.api.UalappApi
import com.bosqueoeste.ualapp.presentation.base.BasePresenter
import com.bosqueoeste.ualapp.utils.subscribeOnAndroid
import javax.inject.Inject

class MealListPresenter @Inject constructor(api: UalappApi) :
    BasePresenter<MealListContract.View>(api), MealListContract.Presenter<MealListContract.View> {


    override fun updateMealList(searchQuery: String) {
        disposable.add(api.getMeals(searchQuery).subscribeOnAndroid()
            .map {
                it.meals?.map {
                    MealUseCase(
                        it
                    )
                }
            }.subscribe({
                view?.showMeals(it.orEmpty())
            }, { view?.showMeals(emptyList()) })
        )
    }

    override fun selectMealItem(itemMeal: ItemMeal) {
        itemMeal.id?.let {
            view?.goToMealDetail(it)
        }
    }

    override fun updateRandomMeal() {
        disposable.add(api.getRandomMeal().subscribeOnAndroid()
            .map {
                it.meals?.get(0)?.let {
                    MealUseCase(
                        it
                    )
                }
            }.subscribe({
                it?.let {
                    view?.showRandomMeal(it)
                    Handler().postDelayed({ updateRandomMeal() }, REFRESH_RANDOM_MEAL_PERIOD)
                }
            }, {

            }
            )
        )
    }

    companion object {
        private const val REFRESH_RANDOM_MEAL_PERIOD = 30000L
    }
}