package com.example.youtube

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.youtube.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        installSplashScreen()

        val networkConnection = NetworkConnection(applicationContext)
        networkConnection.observe(this){
            if (it) {
                binding.contentNoInternet.root.visibility = View.GONE
            } else {
                binding.contentNoInternet.root.visibility = View.VISIBLE
            }
        }

    }


}