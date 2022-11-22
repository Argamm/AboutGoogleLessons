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
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding
import com.example.aboutme.extension.showKeyboard
import com.example.aboutme.hideKeyboardMethodes.hideSoftKeyboard
import com.example.aboutme.hideKeyboardMethodes.showSoftKeyboard


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    private val myName = MyName("Jonny Depp")

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        super.onCreate(savedInstanceState)
//        setContentView(binding.root)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName


        //show keyboard
        showSoftKeyboard(this, binding.nicknameEdit)
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
//                val editedText =
//                    if (nicknameEdit.text?.isNotEmpty() == true)
//                        nicknameEdit.text
//                    else
//                        ""

//                if (editedText?.isNotEmpty() == true) {
                    myName?.nickName = nicknameEdit.text.toString()

                nicknameText.visibility = View.GONE
                nicknameText.visibility = View.VISIBLE
                doneButton.visibility = View.GONE
                nicknameEdit.visibility = View.GONE


                hideSoftKeyboard(binding.nicknameEdit)


//                } else
                invalidateAll()
            }


        }


    }
}