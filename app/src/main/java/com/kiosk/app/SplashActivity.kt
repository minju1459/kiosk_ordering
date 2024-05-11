package com.kiosk.app

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.kiosk.app.databinding.ActivitySplashBinding
import com.sopt.instagram.util.binding.BindingActivity

class SplashActivity : BindingActivity<ActivitySplashBinding>(R.layout.activity_splash) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 1500)
    }
}
