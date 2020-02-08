package com.bosqueoeste.ualapp.app

import android.app.Application
import com.bosqueoeste.ualapp.dagger.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class UalappApplication : Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjection: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)
    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjection
}