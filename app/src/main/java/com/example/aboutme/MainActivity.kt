package com.example.aboutme

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.aboutme.databinding.ActivityMainBinding
import com.example.aboutme.extension.showKeyboard


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        //show keyboard
        showSoftKeyboard(binding.nicknameEdit)
        //hide keyboard
        binding.root.setOnClickListener {

            hideSoftKeyboard(binding.nicknameEdit)
        }

        binding.scrollView.setOnTouchListener { view, motionEvent ->

            hideSoftKeyboard(binding.nicknameEdit)
            false
        }




        binding.doneButton.setOnClickListener {
            with(binding) {
                val editedText =
                    if (nicknameEdit.text?.isNotEmpty() == true)
                        nicknameEdit.text
                    else
                        ""

                if (editedText?.isNotEmpty() == true) {
                    nicknameText.text = editedText
                    nicknameText.visibility = View.VISIBLE

                    doneButton.visibility = View.GONE
                    nicknameEdit.visibility = View.GONE

                    hideSoftKeyboard(binding.nicknameEdit)


                } else
                    nicknameText.visibility = View.GONE
            }


        }


    }

    private fun showSoftKeyboard(view: View) {
        if (view.requestFocus()) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
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

    private fun hideSoftKeyboard(view: View?) {
        if (view != null) {
            val inputManager =
                view.context.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            inputManager.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}