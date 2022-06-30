package com.example.coroutineplayground.androidExample

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.coroutineplayground.R
import kotlinx.coroutines.*

class SimulateAPIDataFetching : AppCompatActivity() {
    //Note: 두가지 인스턴스 정의, API call result 를 보여줄 것임.
    private val result1 = "Result#1"
    private val result2 = "Result#2"

    private lateinit var textView: TextView
    private lateinit var button: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        button = findViewById(R.id.button)
        button.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                fakeAPIRequest()
            }
        }
    }
    //This Functions will set the downloaded result to textView on the main thread
    private fun setText(input: String){
        val newText = textView.text.toString() + "\n$input"
        textView.text = newText
    }
    private suspend fun setTextOnMainThread(input: String){
        withContext(Dispatchers.Main){
            setText(input)
        }
    }

    //The following function will simulate an API call
    private suspend fun fakeAPIRequest(){
        val result1 = getResult1FromApi()
        println("debug: $result1")
        setTextOnMainThread(result1)
        val result2 = getResult2FromApi()
        setTextOnMainThread(result2)
    }

    private suspend fun getResult1FromApi(): String{
        logThread("getResult1FromApi")
        delay(100)
        return result1
    }

    private suspend fun getResult2FromApi(): String{
        logThread("getResult2FromApi")
        delay(50)
        return result2
    }

    private fun logThread(methodName: String){
        println("debug: ${methodName}: ${Thread.currentThread().name}")
    }

}