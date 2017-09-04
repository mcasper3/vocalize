package io.github.mcasper3.vocalize.login

import com.spotify.sdk.android.authentication.AuthenticationClient
import com.spotify.sdk.android.authentication.AuthenticationRequest
import com.spotify.sdk.android.authentication.AuthenticationResponse
import javax.inject.Inject

class LoginHelper @Inject constructor() {

    fun logInWithSpotify() {
        val builder = AuthenticationRequest.Builder(CLIENT_ID, AuthenticationResponse.Type.TOKEN, REDIRECT_URI)

        builder.setScopes(arrayOf("user-read-private", "streaming", "playlist-read-private", "playlist-read-collaborative"))

        val activity = event.getActivity()
        if (activity is LoginActivity) {
            builder.setShowDialog(false)
        }
        val request = builder.build()

        AuthenticationClient.openLoginActivity(event.getActivity(), LOGIN_REQUEST_CODE, request)
    }

}