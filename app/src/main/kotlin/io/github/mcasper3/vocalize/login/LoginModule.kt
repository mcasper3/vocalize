package io.github.mcasper3.vocalize.login

import dagger.Binds
import dagger.Module
import io.github.mcasper3.vocalize.activity.VocalizeActivity

@Module
abstract class LoginModule {
    @Binds
    abstract fun provideVocalizeActivity(loginActivity: LoginActivity): VocalizeActivity<*, *>
}