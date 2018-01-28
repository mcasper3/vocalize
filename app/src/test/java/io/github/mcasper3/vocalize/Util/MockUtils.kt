package io.github.mcasper3.vocalize.Util

import android.annotation.SuppressLint
import android.content.SharedPreferences
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.whenever

class MockUtils {

    companion object {
        @SuppressLint("CommitPrefEdits")
        fun setUpMockSharedPreferences(sharedPreferences: SharedPreferences, editor: SharedPreferences.Editor) {
            whenever(sharedPreferences.edit())
                    .thenReturn(editor)

            whenever(editor.putString(any(), any()))
                    .thenReturn(editor)

            whenever(editor.clear())
                               .thenReturn(editor)

            whenever(editor.putBoolean(any(), any()))
                    .thenReturn(editor)

            whenever(editor.putFloat(any(), any()))
                    .thenReturn(editor)

            whenever(editor.putInt(any(), any()))
                    .thenReturn(editor)

            whenever(editor.putLong(any(), any()))
                    .thenReturn(editor)

            whenever(editor.putStringSet(any(), any()))
                    .thenReturn(editor)
        }
    }
}