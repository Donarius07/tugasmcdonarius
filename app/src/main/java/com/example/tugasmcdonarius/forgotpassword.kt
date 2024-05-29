package com.example.tugasmcdonarius

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tugasmcdonarius.databinding.ActivityForgotpasswordBinding
import com.google.firebase.auth.FirebaseAuth


class forgotpassword : AppCompatActivity() {
    private lateinit var binding: ActivityForgotpasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgotpassword)

        binding = ActivityForgotpasswordBinding.inflate(layoutInflater)

        binding.btnResetPassword.setOnClickListener {
            val email : String = binding.editTextEmail.text.toString().trim()
            if (email.isEmpty()){
                binding.editTextEmail.error = "Input Email"
                binding. editTextEmail.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.editTextEmail.error = "Invalid Email"
                binding.editTextEmail. requestFocus()
                return@setOnClickListener
            }

            FirebaseAuth.getInstance().sendPasswordResetEmail(email).addOnCompleteListener{
                if (it.isSuccessful){
                    Toast.makeText(this,"cek email for reset password", Toast.LENGTH_SHORT).show()
                    Intent(this, login::class.java).also{
                        it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(it)
                    }
                }
                else {
                    Toast.makeText(this,"${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
}