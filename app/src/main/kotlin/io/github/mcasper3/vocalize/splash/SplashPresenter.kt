package io.github.mcasper3.vocalize.splash

import android.content.SharedPreferences
import io.github.mcasper3.vocalize.base.Presenter
import io.github.mcasper3.vocalize.login.LoginHelper
import io.github.mcasper3.vocalize.util.TimeInMs
import javax.inject.Inject

class SplashPresenter @Inject constructor(
        private val sharedPrefs: SharedPreferences,
        private val loginHelper: LoginHelper
) : Presenter<SplashView>() {

    override fun attach(view: SplashView) {
        super.attach(view)

        checkLoginState()
    }

    fun onReauthenticated(token: String, tokenTtl: TimeInMs) {
        checkViewAttached()

        loginHelper.storeToken(token, tokenTtl)

        view?.moveToMainScreen()
    }

    fun onReauthenticationFailed() {
        checkViewAttached()

        view?.moveToLoginScreen()
    }

    private fun checkLoginState() {
        if (sharedPrefs.getBoolean(LoginHelper.IS_LOGGED_IN, false)) {
            reauthenticateIfNeeded()
        } else {
            view?.moveToLoginScreen()
        }
    }

    private fun reauthenticateIfNeeded() {
        val lastLoginTime = sharedPrefs.getLong(LoginHelper.LAST_LOGIN_TIME, 0)
        val expirationTime = sharedPrefs.getLong(LoginHelper.LOGIN_TTL, 0)

        if (System.currentTimeMillis() > lastLoginTime + expirationTime) {
            loginHelper.logInWithSpotify()
        } else {
            view?.moveToMainScreen()
        }
    }
}
