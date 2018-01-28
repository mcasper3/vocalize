package io.github.mcasper3.vocalize.splash

import android.content.Intent
import com.spotify.sdk.android.authentication.AuthenticationClient
import com.spotify.sdk.android.authentication.AuthenticationResponse
import io.github.mcasper3.vocalize.activity.VocalizeActivity
import io.github.mcasper3.vocalize.login.LoginActivity
import timber.log.Timber
import javax.inject.Inject

class SplashActivity : VocalizeActivity<SplashPresenter, SplashView>(), SplashView {

    @Inject override lateinit var presenter: SplashPresenter

    override fun moveToLoginScreen() {
        startActivity(LoginActivity.createIntent(this))
    }

    override fun moveToMainScreen() {
        // TODO
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == com.spotify.sdk.android.authentication.LoginActivity.REQUEST_CODE) {
            val response = AuthenticationClient.getResponse(resultCode, intent)
            when (response.type) {
                AuthenticationResponse.Type.TOKEN ->
                    presenter.onReauthenticated(response.accessToken, response.expiresIn.toLong())
                else -> {
                    presenter.onReauthenticationFailed()
                    Timber.e("Unexpected token response type")
                }
            }
        }
    }
}
