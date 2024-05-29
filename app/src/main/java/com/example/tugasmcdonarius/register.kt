package com.example.tugasmcdonarius

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tugasmcdonarius.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class register : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        FirebaseAuth.getInstance().also { firebaseAuth = it }

        binding.btnRegister.setOnClickListener {
            val email: String = binding.editEmail.text.toString().trim()
            val password: String = binding.editPassword.text.toString().trim()
            val confirmPassword: String = binding.etPassword.text.toString().trim()

            if (email.isEmpty()) {
                binding.editEmail.error = "Input Email"
                binding.editEmail.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.editEmail.error = "Invalid Email"
                binding.editEmail.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty() || password.length < 6) {
                binding.editPassword.error = "password must be more than 6 characters"
                binding.editPassword.requestFocus()
                return@setOnClickListener
            }

            if (password != confirmPassword) {
                binding.etPassword.error = "password must be match"
                binding.etPassword.requestFocus()
                return@setOnClickListener
            }

            registerUser(email, password)
        }

            binding.tvLogin.setOnClickListener {
                startActivity(Intent(this, login::class.java))
            }
        }

        private fun registerUser(email: String, password: String) {

            firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                if (it.isSuccessful) {
                    Intent(this, login::class.java).also {
                        it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(it)
                    }
                } else {
                    Toast.makeText(this, it.exception?.message, Toast.LENGTH_SHORT).show()
                }
            }
        }

        override fun onStart() {
            super.onStart()
            if (firebaseAuth.currentUser != null) {
                Intent(this, home::class.java).also {
                    it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(it)
                }
            }
        }
    }



