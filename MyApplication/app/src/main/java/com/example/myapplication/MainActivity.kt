package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val EXTRA_TEXT = "text_to_display"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val premierBouton : Button = findViewById(R.id.premierButton)
        val textView: TextView = findViewById(R.id.textView)
        val editText: EditText = findViewById(R.id.editText)


        val layoutPrincipal: ConstraintLayout = findViewById(R.id.main)

        premierBouton.setOnClickListener {
            val userInput = editText.text.toString()
            if (userInput == "Afficher nouveau TextView"){
                val deuxiemeTextView = TextView(this)
                deuxiemeTextView.text = "Afficher nouveau TextView"
                layoutPrincipal.addView(deuxiemeTextView)
            }else {
                textView.text = userInput
            }
        }

        val buttonNext: Button = findViewById(R.id.next)

        buttonNext.setOnClickListener {
            val VOSDONNES = editText.text.toString()
            val intent = Intent(this@MainActivity, MainActivity2::class.java)
            intent.putExtra(EXTRA_TEXT, VOSDONNES)
            startActivity(intent)
        }
    }
}