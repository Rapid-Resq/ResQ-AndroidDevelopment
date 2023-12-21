package com.kai.capstone_rapidresq.ui.login

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.kai.capstone_rapidresq.MainActivity
import com.kai.capstone_rapidresq.databinding.ActivityLoginBinding
import com.kai.capstone_rapidresq.ui.register.RegisterActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var userName: EditText
    private lateinit var loginBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        userName = binding.emailEditText
        loginBtn = binding.btnLogin

        binding.tvToRegister.setOnClickListener { toRegister() }
        binding.btnLogin.setOnClickListener { navigateToHome() }
        loginSuccess()
    }

    private fun loginSuccess(){
        val result = userName.text
        loginBtn.isEnabled = result != null && result.toString().isNotEmpty()

        userName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                loginSuccess()
            }

            override fun afterTextChanged(s: Editable?) {

            }
        })
    }

    private fun toRegister() {
        intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToHome() {
        intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}