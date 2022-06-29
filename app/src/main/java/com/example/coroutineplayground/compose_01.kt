package com.example.coroutineplayground

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis


//Note: coroutine, just like in the regular code, is sequential by default
//Note: 일반적인 코드와 같이 코루틴은 기본적으로 연속성이다.
//Note: 1. to simplify code that executes asynchronously.
//Note: 2. converts async callbacks to sequential code.
//Note: 3. Use suspendFunction to make async code sequential
fun main() = runBlocking {
    val time = measureTimeMillis {
        val one = doSomethingUsefulOne()
        val two = doSomethingUsefulTwo()
        println("The answer is ${one + two}")
    }
    println("Completed in $time ms")
}

suspend fun doSomethingUsefulOne(): Int{
    delay(1000L) //pretend we are doing something useful here
    println("one: 13")
    return 13
}

suspend fun doSomethingUsefulTwo(): Int{
    delay(1000L) //pretend we are doing something useful here, too
    println("two: 29")
    return 29
}