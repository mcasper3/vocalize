package io.github.mcasper3.vocalize.application

import android.content.Context
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import io.github.mcasper3.vocalize.BuildConfig
import io.github.mcasper3.vocalize.util.logging.ProdTree
import timber.log.Timber

class VocalizeApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = appComponent

    val appComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder()
                .application(this)
                .build()
    }

    override fun onCreate() {
        super.onCreate()

        appComponent.inject(this)

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            Timber.plant(ProdTree())
        }
    }

    companion object {
        fun get(context: Context): VocalizeApplication =
                context.applicationContext as VocalizeApplication
    }
}