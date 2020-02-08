package com.bosqueoeste.ualapp.dagger

import com.bosqueoeste.ualapp.presentation.list.MealListActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MealListActivity
}