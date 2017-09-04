package io.github.mcasper3.vocalize.splash

import io.github.mcasper3.vocalize.base.View

interface SplashView : View {
    fun moveToLoginScreen()

    fun moveToMainScreen()
}