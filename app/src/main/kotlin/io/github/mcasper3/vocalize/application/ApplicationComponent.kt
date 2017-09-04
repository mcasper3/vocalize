package io.github.mcasper3.vocalize.application

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.support.DaggerApplication
import io.github.mcasper3.vocalize.activity.ActivityBindingModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        ApplicationModule::class,
        AndroidSupportInjectionModule::class,
        ActivityBindingModule::class
))
interface ApplicationComponent : AndroidInjector<DaggerApplication> {
    fun inject(app: VocalizeApplication)

    override fun inject(instance: DaggerApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance fun application(application: Application): ApplicationComponent.Builder

        fun build(): ApplicationComponent
    }
}