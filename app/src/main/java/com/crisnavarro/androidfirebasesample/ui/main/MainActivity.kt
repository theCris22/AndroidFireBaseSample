package com.crisnavarro.androidfirebasesample.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavHost
import androidx.navigation.ui.setupActionBarWithNavController
import com.crisnavarro.androidfirebasesample.R
import com.crisnavarro.androidfirebasesample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        initViews()

    }

    private fun initViews() {
        val navHost = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHost
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

}