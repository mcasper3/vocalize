package io.github.mcasper3.vocalize.splash

import io.github.mcasper3.vocalize.activity.VocalizeActivity
import io.github.mcasper3.vocalize.login.LoginActivity
import javax.inject.Inject

class SplashActivity : VocalizeActivity<SplashPresenter, SplashView>(), SplashView {

    @Inject override lateinit var presenter: SplashPresenter

    override fun moveToLoginScreen() {
        startActivity(LoginActivity.createIntent(this))
    }

    override fun moveToMainScreen() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
