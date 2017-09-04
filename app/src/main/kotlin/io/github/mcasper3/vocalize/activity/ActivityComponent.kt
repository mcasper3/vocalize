package io.github.mcasper3.vocalize.activity

import dagger.Subcomponent
import io.github.mcasper3.vocalize.dagger.scope.ActivityScope
import io.github.mcasper3.vocalize.splash.SplashActivity

@ActivityScope
@Subcomponent(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
    fun inject(splashActivity: SplashActivity)
}