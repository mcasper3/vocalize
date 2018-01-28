package io.github.mcasper3.vocalize.login

import android.content.SharedPreferences
import io.github.mcasper3.vocalize.base.Presenter
import io.github.mcasper3.vocalize.util.TimeInMs
import javax.inject.Inject

class LoginPresenter @Inject constructor(
        private val sharedPrefs: SharedPreferences,
        private val loginHelper: LoginHelper
) : Presenter<LoginView>() {

    fun onLoggedInClicked() {
        checkViewAttached()

        view?.showLoading()
        loginHelper.logInWithSpotify()
    }

    fun onLogInFailed() {
        checkViewAttached()

        view?.hideLoading()
        view?.showLoginError()
    }

    fun onLoggedIn(token: String, tokenTtl: TimeInMs) {
        checkViewAttached()

        loginHelper.storeToken(token, tokenTtl)

        if (sharedPrefs.contains(LoginHelper.HAS_VIEWED_ONBOARDING)) {
            view?.hideLoading()
            view?.moveToMainScreen()
        } else {
            sharedPrefs.edit()
                    .putBoolean(LoginHelper.HAS_VIEWED_ONBOARDING, true)
                    .apply()

            view?.hideLoading()
            view?.moveToOnboarding()
        }
    }
}
