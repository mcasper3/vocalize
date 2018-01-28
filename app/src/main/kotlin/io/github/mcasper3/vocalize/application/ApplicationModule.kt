package io.github.mcasper3.vocalize.application

import android.app.Application
import android.content.Context
import android.preference.PreferenceManager
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class ApplicationModule(private val app: VocalizeApplication) {
    @Binds abstract fun bindContext(application: Application): Context

    @Module
    companion object {
        @Provides
        @JvmStatic fun provideSharedPreferences(context: Context) =
                PreferenceManager.getDefaultSharedPreferences(context)
    }
}
