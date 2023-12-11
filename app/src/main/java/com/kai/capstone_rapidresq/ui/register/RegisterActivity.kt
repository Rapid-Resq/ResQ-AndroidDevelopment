package com.kai.capstone_rapidresq.ui.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kai.capstone_rapidresq.MainActivity
import com.kai.capstone_rapidresq.R
import com.kai.capstone_rapidresq.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.btnRegister.setOnClickListener { toMain() }
    }

    private fun toMain(){
        intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}