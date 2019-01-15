package com.mediaone

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {
    private val SPLASH_DELAY: Long = 2000//5 seconds
    private var mDelayHandler: Handler? = null
    private var mDelayRunnable: Runnable = Runnable {
        if (!isFinishing) {
            startActivity(Intent(this, VideoPlayActivity::class.java))
            finish()

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        mDelayHandler = Handler()
        mDelayHandler?.postDelayed(mDelayRunnable, SPLASH_DELAY)
    }

    override fun onDestroy() {
        super.onDestroy()
        mDelayHandler?.removeCallbacks(mDelayRunnable)
    }
}
