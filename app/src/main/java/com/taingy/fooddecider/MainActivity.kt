package com.taingy.fooddecider

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val foodList = mutableListOf("Hamburger", "Pizza", "Mexican", "American", "Chinese")
        val btnDecide = findViewById<Button>(R.id.btn_decide)
        val tvFood = findViewById<TextView>(R.id.tv_food)
        val btnAdd = findViewById<Button>(R.id.btn_add)
        val etMenu = findViewById<EditText>(R.id.et_menu)

        btnDecide.setOnClickListener {
            val random = Random.nextInt(0, foodList.size)
            tvFood.text = foodList[random]
        }

        btnAdd.setOnClickListener {
            val menu = etMenu.text.toString()
            foodList.add(menu)
            etMenu.text.clear()
            Toast.makeText(this, "$menu added!", Toast.LENGTH_LONG).show()
            it.hideKeyboard()
        }

    }

    fun View.hideKeyboard() {
        val inputMethodManager = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(this.windowToken, 0)
    }
}