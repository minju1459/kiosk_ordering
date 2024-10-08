package com.kiosk.app

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.kiosk.app.databinding.ActivitySplashBinding
import com.kiosk.app.util.binding.BindingActivity

class SplashActivity : BindingActivity<ActivitySplashBinding>(R.layout.activity_splash) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }
}
