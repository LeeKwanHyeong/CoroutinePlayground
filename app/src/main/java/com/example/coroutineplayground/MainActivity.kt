package com.example.coroutineplayground

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.coroutineplayground.androidExample.SimulateAPIDataFetching
import com.example.coroutineplayground.androidExample.UIUpdate
import com.example.coroutineplayground.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var button: Button
    private lateinit var binding: ActivityMainBinding

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apiFetchingButton.setOnClickListener {
            val intent = Intent(this, SimulateAPIDataFetching::class.java)
            startActivity(intent)
        }
        binding.uiUpdateButton.setOnClickListener {
            val intent = Intent(this, UIUpdate::class.java)
            startActivity(intent)
        }
    }
}