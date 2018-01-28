package io.github.mcasper3.vocalize.activity

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.github.mcasper3.vocalize.dagger.scope.ActivityScope
import io.github.mcasper3.vocalize.login.LoginActivity
import io.github.mcasper3.vocalize.login.LoginModule
import io.github.mcasper3.vocalize.main.MainActivity
import io.github.mcasper3.vocalize.main.MainModule
import io.github.mcasper3.vocalize.splash.SplashActivity
import io.github.mcasper3.vocalize.splash.SplashModule

@Module
abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(SplashModule::class))
    abstract fun splashActivity(): SplashActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(LoginModule::class))
    abstract fun loginActivity(): LoginActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(MainModule::class))
    abstract fun mainActivity(): MainActivity
}
