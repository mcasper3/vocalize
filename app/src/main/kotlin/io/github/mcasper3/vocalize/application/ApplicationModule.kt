package io.github.mcasper3.vocalize.application

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module

@Module
abstract class ApplicationModule(private val app: VocalizeApplication) {
    @Binds abstract fun bindContext(application: Application): Context
}