package com.kai.capstone_rapidresq.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kai.capstone_rapidresq.MainActivity
import com.kai.capstone_rapidresq.R
import com.kai.capstone_rapidresq.databinding.ActivityLoginBinding
import com.kai.capstone_rapidresq.ui.register.RegisterActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.tvToRegister.setOnClickListener { toRegister() }
        binding.btnLogin.setOnClickListener { toMain() }
    }

    private fun toRegister() {
        intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }

    private fun toMain() {
        intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}