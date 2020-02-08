package com.bosqueoeste.ualapp.dagger

import android.app.Application
import com.bosqueoeste.ualapp.app.UalappApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(modules = [NetworkModule::class, AppModule::class, ActivityModule::class, PresenterModule::class,AndroidSupportInjectionModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(application: UalappApplication)
}