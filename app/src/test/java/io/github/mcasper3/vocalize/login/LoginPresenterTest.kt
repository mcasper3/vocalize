package io.github.mcasper3.vocalize.login

import android.content.SharedPreferences
import com.nhaarman.mockito_kotlin.mock
import io.github.mcasper3.vocalize.Util.MockUtils
import io.github.mcasper3.vocalize.util.TimeInMs
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify

class LoginPresenterTest {

    private val TOKEN = "spotifyToken"

    private val sharedPrefsEditor = mock<SharedPreferences.Editor>()
    private val  sharedPrefs = mock<SharedPreferences>()
    private val loginHelper = mock<LoginHelper>()
    private val view = mock<LoginView>()

    private lateinit var loginPresenter: LoginPresenter

    @Before
    fun setUp() {
        MockUtils.setUpMockSharedPreferences(sharedPrefs, sharedPrefsEditor)

        loginPresenter = LoginPresenter(sharedPrefs, loginHelper)
        loginPresenter.attach(view)
    }

    @Test
    fun `Verify next page is main content when login succeeds and user has viewed onboarding`() {
        setHasViewedOnboarding(true)

        loginPresenter.onLoggedIn(TOKEN, 0)

        verify(view).moveToMainScreen()
    }

    @Test
    fun `Verify next page is onboarding when login succeeds and user has not viewed onboarding`() {
        setHasViewedOnboarding(false)

        loginPresenter.onLoggedIn(TOKEN, 0)

        verify(view).moveToOnboarding()
    }

    @Test
    fun `Verify error is shown when login fails`() {
        loginPresenter.onLogInFailed()

        verify(view).showLoginError()
    }

    @Test
    fun `Verify token is saved when user logs in`() {
        val tokenTtl: TimeInMs = 3600

        loginPresenter.onLoggedIn(TOKEN, tokenTtl)

        verify(loginHelper).storeToken(TOKEN, tokenTtl)
    }

    private fun setHasViewedOnboarding(value: Boolean) {
        `when`(sharedPrefs.contains(LoginHelper.HAS_VIEWED_ONBOARDING))
                .thenReturn(value)
    }
}