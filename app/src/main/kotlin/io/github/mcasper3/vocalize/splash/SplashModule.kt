package io.github.mcasper3.vocalize.splash

import dagger.Binds
import dagger.Module
import io.github.mcasper3.vocalize.activity.VocalizeActivity

@Module
abstract class SplashModule {
    @Binds abstract fun provideVocalizeActivity(activity: SplashActivity): VocalizeActivity<*, *>
}