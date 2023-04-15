package com.example.youtube

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.example.youtube.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private  lateinit var binding : ActivityMainBinding
    private lateinit var connectivityObserver: ConnectivityObserver
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        connectivityObserver = NetworkConnectivityObserver(applicationContext)
        if (connectivityObserver.observe().toString() != ConnectivityObserver.Status.Available.toString()) {
            findNavController().navigate(R.id.noInternetFragment)
        }



    }
}