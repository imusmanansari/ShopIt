package com.example.shopit.UI.FlashActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.shopit.UI.LoginSignUp.LogInActivity
import com.example.shopit.databinding.ActivityFlashBinding

class FlashActivity : AppCompatActivity() {

    private lateinit var binding:ActivityFlashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityFlashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.flashIcon.alpha=0f
        binding.flashIcon.animate().setDuration(2000).alpha(1f).withEndAction {
            intent= Intent(this, LogInActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right)
            finish()
        }
        binding.appName.alpha=0f
        binding.appName.animate().setDuration(2000).alpha(1f).withEndAction {
            intent= Intent(this, LogInActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right)
            finish()
        }




    }
}