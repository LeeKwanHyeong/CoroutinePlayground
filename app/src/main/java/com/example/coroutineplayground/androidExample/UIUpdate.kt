package com.example.coroutineplayground.androidExample

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.coroutineplayground.R
import com.example.coroutineplayground.databinding.UiUpdateBinding

import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.coroutines.*
import kotlin.random.Random

class UIUpdate : AppCompatActivity() {
//Note: first add dependencies
//    implementation 'com.akexorcist:RoundCornerProgressBar:2.0.3'
//    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core:0.21"
//    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:0.20"


    private lateinit var binding: UiUpdateBinding
    private var raceEnd = false
    private var greenJob: Job? = null
    private var redJob: Job? = null
    private var blueJob: Job? = null



    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = UiUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonStart.setOnClickListener {
            startUpdate()
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        resetRun()
    }


    @RequiresApi(Build.VERSION_CODES.O)
    private fun startUpdate() {
        resetRun()

        greenJob = MainScope().launch{
            startRunning(binding.progressBarGreen)
        }

        redJob = MainScope().launch{
            startRunning(binding.progressBarRed)
        }

        blueJob = MainScope().launch{
            startRunning(binding.progressBarBlue)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private suspend fun startRunning(progressBar: RoundCornerProgressBar){
        progressBar.progress = 0f
        while(progressBar.progress < 1000 && !raceEnd){
            delay(10)
            progressBar.progress += (1..10).random()
        }
        if(!raceEnd){
            raceEnd = true
            Toast.makeText(this, "${progressBar.tooltipText} won!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun ClosedRange<Int>.random() = Random.nextInt(endInclusive - start) + start

    private fun resetRun(){
        raceEnd = false
        greenJob?.cancel()
        blueJob?.cancel()
        redJob?.cancel()
    }

}