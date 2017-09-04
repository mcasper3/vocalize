package io.github.mcasper3.vocalize.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import io.github.mcasper3.vocalize.R
import io.github.mcasper3.vocalize.activity.VocalizeActivity

class LoginActivity : VocalizeActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    companion object {
        fun createIntent(context: Context) = Intent(context, LoginActivity::class.java)
    }
}
