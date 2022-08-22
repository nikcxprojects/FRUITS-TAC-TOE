package com.fruitstactoe.play

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        imageView10.setOnClickListener {
            PreferenceManager.getDefaultSharedPreferences(this).edit()
                .putString("fun", "0").apply()
            startActivity(Intent(this,GamesActivity::class.java))
        }

        imageView9.setOnClickListener {
            PreferenceManager.getDefaultSharedPreferences(this).edit()
                .putString("fun", "1").apply()
            startActivity(Intent(this,GamesActivity::class.java))
        }

    }
}
