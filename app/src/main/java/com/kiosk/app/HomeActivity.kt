package com.kiosk.app

import android.content.Intent
import android.os.Bundle
import com.kiosk.app.databinding.ActivityHomeBinding
import com.sopt.instagram.util.binding.BindingActivity
import com.sopt.instagram.util.extension.setOnSingleClickListener

class HomeActivity : BindingActivity<ActivityHomeBinding>(R.layout.activity_home) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.btnStore.setOnSingleClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.btnTakeOut.setOnSingleClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
