package com.example.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import com.example.colormyviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setListeners()
    }

    private fun setListeners(){
        val clickableViews: List<View> =
            listOf(binding.boxOneText,binding.boxTwoText,binding.boxThreeText,binding.boxFourText,binding.boxFiveText, binding.constraintLayout,
            binding.redButton, binding.yellowButton, binding.greenButton)

        for (item in clickableViews) {
            item.setOnClickListener {
                makeColored(it)
            }
        }
    }

    private fun makeColored(view: View) {
        when(view.id) {
            R.id.box_one_text -> view.setBackgroundColor(Color.CYAN)
            R.id.box_two_text ->view.setBackgroundColor(Color.GRAY)
            R.id.box_three_text ->view.setBackgroundColor(Color.GREEN)

            R.id.box_four_text ->view.setBackgroundResource(R.color.purple_200)
            R.id.box_five_text ->view.setBackgroundResource(R.color.teal_200)

            R.id.redButton ->  binding.boxThreeText.setBackgroundResource(android.R.color.holo_red_dark)
            R.id.yellowButton ->  binding.boxFourText.setBackgroundResource(android.R.color.holo_orange_light)
            R.id.greenButton ->  binding.boxFiveText.setBackgroundResource(android.R.color.holo_green_dark)

            else -> view.setBackgroundColor(Color.BLACK)
        }
    }
}