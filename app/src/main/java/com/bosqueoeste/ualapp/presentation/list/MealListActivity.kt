package com.bosqueoeste.ualapp.presentation.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bosqueoeste.ualapp.R
import com.bosqueoeste.ualapp.presentation.base.BaseActivity
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_meal_list.*
import javax.inject.Inject

class MealListActivity : BaseActivity(), MealListContract.View {

    @Inject
    lateinit var presenter: MealListContract.Presenter<MealListContract.View>

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meal_list)
        setSupportActionBar(toolbarMealList)
        presenter.updateMealList()
    }
}
