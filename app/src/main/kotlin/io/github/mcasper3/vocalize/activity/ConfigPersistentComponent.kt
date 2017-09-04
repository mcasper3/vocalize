package io.github.mcasper3.vocalize.activity

import dagger.Component
import io.github.mcasper3.vocalize.application.ApplicationComponent
import io.github.mcasper3.vocalize.dagger.annotation.ConfigPersistent

@ConfigPersistent
@Component(dependencies = arrayOf(ApplicationComponent::class))
interface ConfigPersistentComponent {
    fun activityComponent(activityModule: ActivityModule): ActivityComponent
}
