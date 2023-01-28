package com.example.githubuser

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.window.SplashScreenView
import androidx.appcompat.app.AppCompatActivity

class LayarActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layar)

        val btn_layar: Button = findViewById(R.id.button_layar)
        btn_layar.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button_layar -> {
                val moveIntent = Intent(this@LayarActivity, Layar2Activity::class.java)
                startActivity(moveIntent)
            }
        }
    }
}

