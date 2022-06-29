package com.example.coroutineplayground

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

//What if there are no dependencies between invocations
//we want to get the answer faster, by doing both concurrently?
//This is twice as fast, because the two coroutines executes concurrently.
//Note that concurrency with coroutines is always explicit


fun main() = runBlocking {
    val time = measureTimeMillis {
        val one = async { doSomethingUsefulOne() }
        val two = async { doSomethingUsefulTwo() }
        println("The answer is ${one.await() + two.await()}")
    }
    println("Completed in $time ms")
}