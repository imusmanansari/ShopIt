package com.example.shopit.UI.LoginSignUp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.shopit.databinding.ActivityForgotPasswordBinding
import com.google.firebase.auth.FirebaseAuth

class ForgotPassword : AppCompatActivity() {
    private lateinit var binding: ActivityForgotPasswordBinding
    private lateinit var FirebasePassReset: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        FirebasePassReset = FirebaseAuth.getInstance()

        binding.btnSubmit.setOnClickListener {
            val restPass = binding.etEmail.text.toString()
            if (restPass == "") {
                Toast.makeText(this, "Enter a valid email Address", Toast.LENGTH_SHORT).show()
            } else {


                FirebasePassReset.sendPasswordResetEmail(restPass)
                    .addOnSuccessListener {

                        intent = Intent(this, LogInActivity::class.java)
                        startActivity(intent)

                        Toast.makeText(

                            this,
                        "Check your Email For Password Reset Link",
                        Toast.LENGTH_SHORT
                        )
                        .show()
                    }
                    .addOnFailureListener {

                        Toast.makeText(this, "Invalid Email Address", Toast.LENGTH_SHORT).show()

                    }
            }
        }


    }
}