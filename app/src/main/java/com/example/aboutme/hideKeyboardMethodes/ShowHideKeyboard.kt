package com.example.aboutme.hideKeyboardMethodes


import android.app.Activity
import android.content.Context
import android.content.Context.INPUT_METHOD_SERVICE
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.core.content.ContextCompat.getSystemService

fun showSoftKeyboard(activity: Activity, view: View) {
    if (view.requestFocus()) {
        val imm = activity.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
    }
}

private fun forceHide(activity: Activity, editText: EditText) {
    if (activity.currentFocus == null || activity.currentFocus !is EditText) {
        editText.requestFocus()
    }
    val imm = activity.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(editText.windowToken, 0)
    activity.window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
}


fun hideSoftKeyboard(activity: Activity?) {
    if (activity != null) {
        val inputManager = activity.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        if (activity.currentFocus != null && inputManager != null) {
            inputManager.hideSoftInputFromWindow(activity.currentFocus!!.windowToken, 0)
            inputManager.hideSoftInputFromInputMethod(activity.currentFocus!!.windowToken, 0)
        }
    }
}

fun hideSoftKeyboard(view: View?) {
    if (view != null) {
        val inputManager =
            view.context.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
