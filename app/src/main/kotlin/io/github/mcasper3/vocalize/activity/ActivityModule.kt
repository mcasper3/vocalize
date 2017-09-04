package io.github.mcasper3.vocalize.activity

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val vocalizeActivity: VocalizeActivity<*, *>) {

    @Provides fun provideContext(): Context = vocalizeActivity
}
