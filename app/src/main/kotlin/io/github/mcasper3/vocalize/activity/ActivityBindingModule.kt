package io.github.mcasper3.vocalize.activity

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.github.mcasper3.vocalize.dagger.scope.ActivityScope
import io.github.mcasper3.vocalize.splash.SplashActivity
import io.github.mcasper3.vocalize.splash.SplashModule

@Module
abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(SplashModule::class))
    abstract fun splashActivity(): SplashActivity
}
