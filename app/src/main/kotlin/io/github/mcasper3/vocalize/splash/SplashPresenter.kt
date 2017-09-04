package io.github.mcasper3.vocalize.splash

import io.github.mcasper3.vocalize.base.Presenter
import javax.inject.Inject

class SplashPresenter @Inject constructor() : Presenter<SplashView>() {
    override fun attach(view: SplashView) {
        super.attach(view)

        // TODO check current state of login
        view.moveToLoginScreen()
    }
}