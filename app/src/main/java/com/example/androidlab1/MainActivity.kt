package com.example.androidlab1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val b1 = findViewById<Button>(R.id.openBirthdayBtn)
        val b2 = findViewById<Button>(R.id.openScrambleBtn)

        b1.setOnClickListener {
            startActivity(Intent(this, BirthdayCardActivity::class.java))
        }
        b2.setOnClickListener {
            startActivity(Intent(this, WordScrambleActivity::class.java))
        }
    }
}
