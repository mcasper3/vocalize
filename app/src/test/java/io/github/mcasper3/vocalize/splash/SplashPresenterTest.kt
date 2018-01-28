package io.github.mcasper3.vocalize.splash

import android.content.SharedPreferences
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.never
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.github.mcasper3.vocalize.Util.MockUtils
import io.github.mcasper3.vocalize.login.LoginHelper
import io.github.mcasper3.vocalize.util.TimeInMs
import org.junit.Before
import org.junit.Test

class SplashPresenterTest {

    private val TOKEN = "spotifyToken"

    private val sharedPrefs = mock<SharedPreferences>()
    private val editor = mock<SharedPreferences.Editor>()
    private val loginHelper = mock<LoginHelper>()
    private val view = mock<SplashView>()

    private lateinit var splashPresenter: SplashPresenter

    @Before fun setUp() {
        MockUtils.setUpMockSharedPreferences(sharedPrefs, editor)

        splashPresenter = SplashPresenter(sharedPrefs, loginHelper)
    }

    @Test
    fun `Verify next screen is main screen when logged in`() {
        setLoggedInState(true)
        setLoginTimes(System.currentTimeMillis(), 360000)

        splashPresenter.attach(view)

        verify(view).moveToMainScreen()
        verify(loginHelper, never()).logInWithSpotify()
    }

    @Test
    fun `Verify next screen is login screen when logged out`() {
        setLoggedInState(false)

        splashPresenter.attach(view)

        verify(view).moveToLoginScreen()
        verify(loginHelper, never()).logInWithSpotify()
    }

    @Test
    fun `Verify user is reauthenticated when login has expired`() {
        setLoggedInState(true)
        setLoginTimes(System.currentTimeMillis() - 720000, 360000)

        splashPresenter.attach(view)

        verify(view, never()).moveToLoginScreen()
        verify(view, never()).moveToMainScreen()
        verify(loginHelper).logInWithSpotify()
    }

    @Test
    fun `Verify token is saved when user is reauthenticated`() {
        val tokenTtl: TimeInMs = 3600

        setLoggedInState(true)
        setLoginTimes(System.currentTimeMillis() - 720000, 360000)

        splashPresenter.attach(view)
        splashPresenter.onReauthenticated(TOKEN, tokenTtl)

        verify(loginHelper).storeToken(TOKEN, tokenTtl)
    }

    @Test
    fun `Verify next screen is main screen when user is reauthenticated`() {
        setLoggedInState(true)
        setLoginTimes(System.currentTimeMillis() - 720000, 360000)

        splashPresenter.attach(view)
        splashPresenter.onReauthenticated(TOKEN, 0)

        verify(view).moveToMainScreen()
    }

    @Test
    fun `Verify next screen is main screen when user reauthentication fails`() {
        setLoggedInState(true)
        setLoginTimes(System.currentTimeMillis() - 720000, 360000)

        splashPresenter.attach(view)
        splashPresenter.onReauthenticationFailed()

        verify(view).moveToLoginScreen()
    }

    private fun setLoggedInState(state: Boolean) {
        whenever(sharedPrefs.getBoolean(LoginHelper.IS_LOGGED_IN, false))
                .thenReturn(state)
    }

    private fun setLoginTimes(lastLoginTime: Long, loginTtl: Long) {
        whenever(sharedPrefs.getLong(LoginHelper.LAST_LOGIN_TIME, 0))
                .thenReturn(lastLoginTime)

        whenever(sharedPrefs.getLong(LoginHelper.LOGIN_TTL, 0))
                .thenReturn(loginTtl)
    }
}
