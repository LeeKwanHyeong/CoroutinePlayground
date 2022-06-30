package com.example.coroutineplayground

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis


//Note: This way, if throws an exception, all the coroutines will be cancelled
fun main() = runBlocking {
    val time = measureTimeMillis {
        println("The answer is ${concurrentSum()}")
    }
    println("Complete in $time ms")
}

suspend fun concurrentSum(): Int = coroutineScope {
    val one = async { doSomethingUsefulOne() }
    val two = async { doSomethingUsefulTwo() }
    one.await() + two.await()
}
