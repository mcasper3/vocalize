package io.github.mcasper3.vocalize.login

import io.github.mcasper3.vocalize.base.View

interface LoginView : View {
    fun moveToOnboarding()
    fun moveToMainScreen()
}