package com.example.assignment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {

    private var randomNum = 0
    private var numOfGuesses = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        newGame()
    }

    fun searchNumber(view: View) {
        var returnMessage = ""
        val numberText = findViewById<TextView>(R.id.text_number)
        val numOfGuessText = findViewById<TextView>(R.id.text_numOfGuesses)
        val searchNumber = Integer.parseInt(numberText.text.toString())

        numOfGuesses++
//        numOfGuessText.text = "$numOfGuesses"

        if (searchNumber == randomNum) {
            returnMessage = "Congrats! You've won with the guess $searchNumber, you took $numOfGuesses try/tries"
            newGame()

        } else {
            returnMessage = if (searchNumber > randomNum) {
                "Oops! The number is lower! Current try/tries: $numOfGuesses"
            } else {
                "Oops! The number is higher! Current try/tries: $numOfGuesses"
            }
        }

        Toast.makeText(this, returnMessage, Toast.LENGTH_SHORT).show()
        numberText.text = ""
    }

    private fun newGame() {
        val numOfGuessText = findViewById<TextView>(R.id.text_numOfGuesses)
        val randomNumberText = findViewById<TextView>(R.id.text_randomNumber)

        randomNum = (1..100).random()
//        randomNumberText.text = "$randomNum"

        numOfGuesses = 0
//        numOfGuessText.text = "$numOfGuesses"
    }
}
