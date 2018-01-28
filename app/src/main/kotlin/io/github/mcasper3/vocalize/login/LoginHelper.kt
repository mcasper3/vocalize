package io.github.mcasper3.vocalize.login

import android.content.SharedPreferences
import android.support.annotation.VisibleForTesting
import com.spotify.sdk.android.authentication.AuthenticationClient
import com.spotify.sdk.android.authentication.AuthenticationRequest
import com.spotify.sdk.android.authentication.AuthenticationResponse
import com.spotify.sdk.android.authentication.LoginActivity.REQUEST_CODE
import io.github.mcasper3.vocalize.BuildConfig
import io.github.mcasper3.vocalize.activity.VocalizeActivity
import io.github.mcasper3.vocalize.util.TimeInMs
import javax.inject.Inject

class LoginHelper @Inject constructor(
        private val activity: VocalizeActivity<*, *>,
        private val sharedPrefs: SharedPreferences
) {

    fun logInWithSpotify() {
        val request = AuthenticationRequest.Builder(BuildConfig.SPOTIFY_CLIENT_ID,
                AuthenticationResponse.Type.TOKEN, BuildConfig.SPOTIFY_REDIRECT_URI)
                .setScopes(
                        arrayOf("user-read-private",
                                "streaming",
                                "playlist-read-private",
                                "playlist-read-collaborative"
                        )
                )
                .setShowDialog(false)
                .build()

        AuthenticationClient.openLoginActivity(activity, REQUEST_CODE, request)
    }

    fun storeToken(token: String, ttl: TimeInMs) {
        sharedPrefs.edit()
                .putString(SPOTIFY_TOKEN, token)
                .putLong(LOGIN_TTL, ttl)
                .putLong(LAST_LOGIN_TIME, System.currentTimeMillis())
                .apply()
    }

    companion object {
        @VisibleForTesting
        internal val HAS_VIEWED_ONBOARDING = "pref_hasViewedOnBoarding"

        @VisibleForTesting
        internal val SPOTIFY_TOKEN = "pref_spotifyToken"

        @VisibleForTesting
        internal val IS_LOGGED_IN = "pref_isLoggedIn"

        @VisibleForTesting
        internal val LAST_LOGIN_TIME = "pref_lastLoginTime"

        @VisibleForTesting
        internal val LOGIN_TTL = "pref_loginTtl"
    }
}