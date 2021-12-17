package com.ozu.cs394.plantsuniverse.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ozu.cs394.plantsuniverse.R
import android.content.Intent




class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        startActivity(Intent(this, MainActivity::class.java))
        finish()

    }
}