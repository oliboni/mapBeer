package br.edu.unochapeco.mapbeer

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val handle = Handler()
        handle.postDelayed({ init() }, 3000)

    }

    fun init(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
