package io.github.mcasper3.vocalize.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import butterknife.OnClick
import io.github.mcasper3.vocalize.R
import io.github.mcasper3.vocalize.activity.VocalizeActivity
import javax.inject.Inject

class LoginActivity : VocalizeActivity<LoginPresenter, LoginView>(), LoginView {

    @Inject override lateinit var presenter: LoginPresenter

    @OnClick(R.id.spotify_log_in_button)
    fun onSpotifyLogin() {

    }

    override fun moveToOnboarding() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun moveToMainScreen() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    override fun onBackPressed() {
        startActivity(
                Intent(Intent.ACTION_MAIN)
                        .addCategory(Intent.CATEGORY_HOME)
        )
    }

    companion object {
        fun createIntent(context: Context) = Intent(context, LoginActivity::class.java)
    }
}
