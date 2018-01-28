package io.github.mcasper3.vocalize.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import butterknife.bindView
import com.spotify.sdk.android.authentication.AuthenticationClient
import com.spotify.sdk.android.authentication.AuthenticationResponse
import com.spotify.sdk.android.authentication.LoginActivity.REQUEST_CODE
import io.github.mcasper3.vocalize.R
import io.github.mcasper3.vocalize.activity.VocalizeActivity
import timber.log.Timber
import javax.inject.Inject

class LoginActivity : VocalizeActivity<LoginPresenter, LoginView>(), LoginView {

    @Inject override lateinit var presenter: LoginPresenter

    private val loginButton: Button by bindView(R.id.spotify_log_in_button)
    private val progressBar: View by bindView(R.id.login_progress_bar)
    private val loadingBackground: View by bindView(R.id.loading_background)

    override fun moveToOnboarding() {
        // TODO
    }

    override fun moveToMainScreen() {
        // TODO
    }

    override fun showLoginError() {
        // TODO
    }

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
        loadingBackground.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressBar.visibility = View.INVISIBLE
        loadingBackground.visibility = View.INVISIBLE
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginButton.setOnClickListener {
            presenter.onLoggedInClicked()
            Timber.i("Login clicked")
        }
    }

    override fun onBackPressed() {
        startActivity(
                Intent(Intent.ACTION_MAIN)
                        .addCategory(Intent.CATEGORY_HOME)
        )
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        presenter.attach(this)

        if (requestCode == REQUEST_CODE) {
            val response = AuthenticationClient.getResponse(resultCode, intent)
            when (response.type) {
                AuthenticationResponse.Type.TOKEN ->
                    presenter.onLoggedIn(response.accessToken, response.expiresIn.toLong())
                else -> {
                    Timber.e("Unexpected token response type " + response.accessToken + " (error: " + response.error + ")" + response.state + "" + response.type)
                    presenter.onLogInFailed()
                }
            }
        }
    }

    companion object {
        fun createIntent(context: Context) = Intent(context, LoginActivity::class.java)
    }
}
