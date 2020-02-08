package com.bosqueoeste.ualapp.presentation.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.bosqueoeste.ualapp.R
import com.bosqueoeste.ualapp.presentation.base.BaseActivity
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_meal_detail.*
import javax.inject.Inject

class MealDetailActivity : BaseActivity(), MealDetailContract.View {

    @Inject
    lateinit var presenter: MealDetailContract.Presenter<MealDetailContract.View>


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meal_detail)
        presenter.view = this
        intent.getStringExtra(MEAL_ID_KEY)?.let {
            presenter.getMealById(it)
        }
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun showMealDetail(meal: MealDetailUseCase) {
        title = meal.title
        titleMealDetail.text = meal.title
        textMealDetailInstructions.text = meal.instructions
        textMealDetailIngredients.text = meal.ingredientsLabel
    }

    companion object {
        fun getIntent(context: Context, idMeal: String) =
            Intent(context, MealDetailActivity::class.java).apply {
                putExtra(MEAL_ID_KEY, idMeal)
            }

        private const val MEAL_ID_KEY = "MEAL_ID_KEY"
    }
}
