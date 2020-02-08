package com.bosqueoeste.ualapp.dagger

import com.bosqueoeste.ualapp.presentation.detail.MealDetailActivity
import com.bosqueoeste.ualapp.presentation.list.MealListActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun bindMealListActivity(): MealListActivity

    @ContributesAndroidInjector
    abstract fun bindMealDetailActivity(): MealDetailActivity
}