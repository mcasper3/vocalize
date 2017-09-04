package io.github.mcasper3.vocalize.splash

import io.github.mcasper3.vocalize.activity.VocalizeActivity
import io.github.mcasper3.vocalize.login.LoginActivity
import javax.inject.Inject

class SplashActivity : VocalizeActivity(), SplashView {

    @Inject lateinit var presenter: SplashPresenter

    override fun onResume() {
        super.onResume()
        presenter.attach(this)
    }

    override fun onPause() {
        presenter.detatch()
        super.onPause()
    }

    override fun moveToLoginScreen() {
        startActivity(LoginActivity.createIntent(this))
    }

    override fun moveToMainScreen() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}