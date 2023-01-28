package com.example.githubuser

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class Layar2Activity : AppCompatActivity() {
    private val second = 2000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layar2)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this@Layar2Activity, MainActivity::class.java))
            finish()
        }, second)
    }
}