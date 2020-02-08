package com.bosqueoeste.ualapp.presentation.detail

import android.os.Bundle
import com.bosqueoeste.ualapp.R
import com.bosqueoeste.ualapp.presentation.base.BaseActivity
import com.bosqueoeste.ualapp.presentation.list.MealUseCase
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
        setSupportActionBar(toolbarMealDetail)
        presenter.view = this
    }

    override fun showMealDetail(meals: MealUseCase) {

    }
}
