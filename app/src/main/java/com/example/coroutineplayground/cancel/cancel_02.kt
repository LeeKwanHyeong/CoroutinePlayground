package com.example.coroutineplayground

import kotlinx.coroutines.*

fun main() = runBlocking {
    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default){
        try{
            var nextPrintTIme = startTime
            var i = 0
            while(i < 5){ //computation loop, just wastes CPU
                //print a message twice a second
                if(System.currentTimeMillis() >= nextPrintTIme){
//                delay(1L)
//                yield()
                    println("job: I'm sleeping ${i++} ...")
                    nextPrintTIme += 500L
                }
            }
        }catch (e: Exception){
            kotlin.io.println("Exception [$e]")
        }

    }
    delay(1300L)
    println("main: I'm tired of waiting!")
    job.cancelAndJoin()  //cancel the job and waits for its completion ==> 일을 캔슬하고 이것이 완료될때까지 기다리라..
    println("main: Now I can quit")
}