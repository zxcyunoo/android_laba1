package com.example.androidlab1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class WordScrambleActivity : AppCompatActivity() {

    private lateinit var shuffledWordText: TextView
    private lateinit var guessEditText: EditText
    private lateinit var checkBtn: Button
    private lateinit var resultText: TextView

    private val words = listOf(
        "android", "kotlin", "developer", "birthday", "scramble",
        "computer", "internet", "activity", "fragment", "variable"
    )

    private var currentWord: String = ""
    private var shuffledWord: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_word_scramble)

        shuffledWordText = findViewById(R.id.shuffledWordText)
        guessEditText = findViewById(R.id.guessEditText)
        checkBtn = findViewById(R.id.checkBtn)
        resultText = findViewById(R.id.resultText)

        startNewRound()

        checkBtn.setOnClickListener { checkAnswer() }
    }

    private fun startNewRound() {
        currentWord = words.random()
        shuffledWord = shuffleWord(currentWord)

        shuffledWordText.text = shuffledWord
        guessEditText.setText("")
        resultText.text = ""
    }

    private fun shuffleWord(word: String): String {
        if (word.length < 2) return word

        val chars = word.toCharArray().toMutableList()
        do {
            chars.shuffle(Random(System.currentTimeMillis()))
        } while (chars.joinToString("").equals(word, ignoreCase = true))

        return chars.joinToString("")
    }

    private fun checkAnswer() {
        val guess = guessEditText.text.toString().trim()

        if (guess.isEmpty()) {
            Toast.makeText(this, "Введи слово 🙂", Toast.LENGTH_SHORT).show()
            return
        }

        if (guess.equals(currentWord, ignoreCase = true)) {
            Toast.makeText(this, "✅ Правильно! Молодець 🎉", Toast.LENGTH_SHORT).show()
            startNewRound()
        } else {
            resultText.text = "❌ Неправильно, спробуй ще раз"
        }
    }
}
