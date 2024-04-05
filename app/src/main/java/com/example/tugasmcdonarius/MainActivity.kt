package com.example.tugasmcdonarius

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tugasmcdonarius.databinding.LoginBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: LoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mengatur onClickListener untuk TextView tvSignUp
        binding.btnLogin.setOnClickListener {
            // Membuat intent untuk pindah ke SignUpActivity
            val intenthome = Intent(this, home::class.java)
            startActivity(intenthome)

            // Mengatur onClickListener untuk TextView tvSignUp
            binding.tvForgotPassword.setOnClickListener {
                // Membuat intent untuk pindah ke SignUpActivity
                val intentforgotpassword = Intent(this, forgotpassword::class.java)
                startActivity(intentforgotpassword)

                // Mengatur onClickListener untuk TextView tvSignUp
                binding.tvSignUp.setOnClickListener {
                    // Membuat intent untuk pindah ke SignUpActivity
                    val intenttvSignUp = Intent(this, register::class.java)
                    startActivity(intenttvSignUp)
                }
            }
        }
    }
}
