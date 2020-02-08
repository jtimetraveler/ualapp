package com.bosqueoeste.ualapp.dagger

import com.bosqueoeste.ualapp.data.api.UalappApi
import com.bosqueoeste.ualapp.presentation.list.MealListContract
import com.bosqueoeste.ualapp.presentation.list.MealListPresenter
import dagger.Module
import dagger.Provides

@Module
class PresenterModule {

    @Provides
    fun provideMealPresenter(api:UalappApi) : MealListContract.Presenter<MealListContract.View> = MealListPresenter(api)
}