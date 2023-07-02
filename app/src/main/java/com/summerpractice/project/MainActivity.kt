package com.summerpractice.project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.summerpractice.project.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val newBinding = ActivityMainBinding.inflate(layoutInflater)
        binding = newBinding
        setContentView(newBinding.root)
    }

    fun Calculate(view: View) {
        val nameLen = binding.editTextText.text.toString().length
        val growth = Integer.parseInt(binding.editTextText2.text.toString())
        val weight = binding.editTextText3.text.toString().toDouble()
        val age = Integer.parseInt(binding.editTextText4.text.toString())
        val flag = Validation(nameLen, growth, weight, age)
        val viewResult = binding.textView5

        if (flag) {
            var result: Double = nameLen + growth + weight + age
            viewResult.text = "Result:" + result.toString()
        } else viewResult.text = "Incorrect data"
    }

    fun Validation(nameLen: Int, growth: Int, weight: Double, age: Int): Boolean {
        return nameLen <= 50 &&
                growth > 0 && growth <= 250 &&
                weight > 0 && weight < 250 &&
                age > 0 && age <= 150
    }
}