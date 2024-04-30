package com.example.icetask3

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    private var secretNumber = 0
    private var attempts = 0
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView: TextView = findViewById(R.id.textView)
        val viewText: TextView = findViewById(R.id.viewText)
        val enterButton: Button = findViewById(R.id.enterButton)
        val printText: TextView = findViewById(R.id.printText)
        val clearButton : Button = findViewById(R.id.clearButton)
        val enterNumber: EditText = findViewById(R.id.enterNumber)

        secretNumber = Random.nextInt(1,101)

        enterButton.setOnClickListener{
            val guess = enterNumber.text.toString().toIntOrNull()

            if (guess == null) {
                printText.text = "Please enter a Valid number"
                return@setOnClickListener
            }
            attempts++
            when {
                guess < secretNumber -> printText.text = "Wrong Number, Try Again"
                guess > secretNumber -> printText.text = "Wrong Number, Try Again"

                else -> {
                    printText.text = "Congratulations! Your have guessed the Number"
                    enterButton.isEnabled = false

                }
            }
        }
        clearButton.setOnClickListener{
            enterNumber.text.clear()
            printText.text =" "
            enterButton.isEnabled = true
        }

    }
}