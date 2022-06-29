package com.example.coroutineplayground

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

//We can define async-style functions
//xxxAsync functions are not suspending functions
//They can be used from anywhere
//Warning: Using this style with Kotlin coroutines is strongly discouraged
//Warning: This problem does not happen with structured concurrency


fun main(){
    val time = measureTimeMillis {
        val one = somethingUsefulOneAsync()
        val two = somethingUsefulTwoAsync()
        runBlocking { println("The answer is ${one.await() + two.await()}") }
    }
    println("Completed in $time ms")
}

fun somethingUsefulOneAsync() = GlobalScope.async { doSomethingUsefulOne() }
fun somethingUsefulTwoAsync() = GlobalScope.async { doSomethingUsefulTwo() }
