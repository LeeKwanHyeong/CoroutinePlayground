package com.example.coroutineplayground

import kotlinx.coroutines.*


fun main() = runBlocking {
    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default){
        try{
            var nextPrintTime = startTime
            var i = 0
            kotlin.io.println("isActive $isActive ...")
            while(isActive){ //cancellable computation loop
                //print a message twice a second
                if(System.currentTimeMillis() >= nextPrintTime){
                    println("job: I'm sleeping ${i++} ...")
                    nextPrintTime += 500L
                }
            }
            kotlin.io.println("isActive $isActive ...")
        }catch (e: Exception){
            println("Exception $e ...")
        }


    }
    delay(1300L)
    println("main: I'm tired of waiting")
    job.cancelAndJoin()
    println("main: Now I can quit")
}