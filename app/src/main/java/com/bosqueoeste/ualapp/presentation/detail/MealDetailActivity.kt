package com.bosqueoeste.ualapp.presentation.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.bosqueoeste.ualapp.R
import com.bosqueoeste.ualapp.presentation.base.BaseActivity
import com.bosqueoeste.ualapp.presentation.list.MealUseCase
import dagger.android.AndroidInjection
import javax.inject.Inject

class MealDetailActivity : BaseActivity(), MealDetailContract.View {

    @Inject
    lateinit var presenter: MealDetailContract.Presenter<MealDetailContract.View>


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meal_detail)
        presenter.view = this
    }

    override fun showMealDetail(meals: MealUseCase) {

    }

    companion object {
        fun getIntent(context: Context, idMeal: String) =
            Intent(context, MealDetailActivity::class.java).apply {
                putExtra(MEAL_ID_KEY, idMeal)
            }

        private const val MEAL_ID_KEY = "MEAL_ID_KEY"
    }
}
