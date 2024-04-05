package com.example.tugasmcdonarius

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tugasmcdonarius.databinding.ActivityForgotpasswordBinding


class forgotpassword : AppCompatActivity() {
    private lateinit var binding: ActivityForgotpasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotpasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnResetPassword.setOnClickListener {
            val intentbtnResetPassword = Intent(this,register::class.java)
            startActivity(intentbtnResetPassword)
        }

    }
}