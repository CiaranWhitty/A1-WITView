package com.example.a1_witview.ui

import android.content.Intent
//import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.a1_witview.MainActivity
import com.example.a1_witview.R
import com.example.a1_witview.ui.firebase.SignIn
import kotlinx.android.synthetic.main.app_bar_main.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        setSupportActionBar(toolbar)

        makeFullScreen()
        // Using a handler to delay loading the MainActivity
        Handler().postDelayed({
            // Start activity
            startActivity(Intent(this, SignIn::class.java))
            // Animate the loading of new activity
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            // Close this activity
            finish()
        }, 2000)
    }

    private fun makeFullScreen() {

        // Make Fullscreen
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        // Hide the toolbar
        supportActionBar?.hide()
    }
}
