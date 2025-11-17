package com.example.randomcolorgeneratorhex

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import kotlin.random.Random

class CreateButtonArgs () {

    @SuppressLint("SetTextI18n")
    fun createButtonArgs(button: Button) {

        button.height = 40 / 2
        button.width = 150 * 3
        button.text = "Set Text"

    }

}

class TextViewArgs () {

    @SuppressLint("SetTextI18n")
    fun createViewArgs(textView: TextView, data: String) {

        textView.text = data.uppercase()
        textView.textSize = 45f / 2f

    }

}

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val textView: TextView = findViewById(R.id.textView)
        val textViewArgs = TextViewArgs()
        textViewArgs.createViewArgs(textView, "")

        val button: Button = findViewById(R.id.Button)
        val btn = CreateButtonArgs()
        btn.createButtonArgs(button)

        button.setOnClickListener {

            val rValue = Random.nextInt(1, 255)
            val gValue = Random.nextInt(1, 255)
            val bValue = Random.nextInt(1, 255)

            val hexR: String = rValue.toString(16)
            val hexG: String = gValue.toString(16)
            val hexB: String = bValue.toString(16)


            textView.text = "$hexR$hexG$hexB"
            val backInside = findViewById<CoordinatorLayout>(R.id.layout)
            backInside.setBackgroundColor(Color.rgb(rValue, gValue, bValue))

            button.text = "#$hexR$hexG$hexB"
        }

    }
}