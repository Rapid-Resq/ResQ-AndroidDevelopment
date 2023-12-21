package com.kai.capstone_rapidresq.ui.register

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kai.capstone_rapidresq.databinding.ActivityRegisterBinding
import com.kai.capstone_rapidresq.ui.login.LoginActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.btnRegister.setOnClickListener { toLogin() }
    }

    private fun toLogin(){
        intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}