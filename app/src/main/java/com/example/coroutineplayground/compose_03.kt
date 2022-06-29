package com.example.coroutineplayground

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

//Optionally, async can be made lazy by setting its start parameter
//its result is required by await, or if its Job's start function is invoked
//if we just call await in println without first calling start


fun main() = runBlocking {
    val time = measureTimeMillis {
        val one = async(start = CoroutineStart.LAZY){ doSomethingUsefulOne() }
        val two = async(start = CoroutineStart.LAZY){ doSomethingUsefulTwo() }
        //some computation
        one.start() //start the first one
        two.start() //start the second one
        println("The answer is ${one.await() + two.await()}")
    }
    println("Completed in $time ms")
}
