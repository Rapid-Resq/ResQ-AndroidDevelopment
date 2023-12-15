package com.kai.capstone_rapidresq.ui.splashScreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.kai.capstone_rapidresq.MainActivity
import com.kai.capstone_rapidresq.R
import com.kai.capstone_rapidresq.ui.login.LoginActivity

class SplashScreenActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT: Long = 3000 // in milliseconds (3 seconds)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        supportActionBar?.hide()

        Handler().postDelayed({
            // Intent to navigate to the main activity
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish() // close splash screen activity
        }, SPLASH_TIME_OUT)
    }
}
