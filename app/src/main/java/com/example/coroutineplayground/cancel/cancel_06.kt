package com.example.coroutineplayground

import kotlinx.coroutines.*

fun main() = runBlocking {
    withTimeout(1300L){
        repeat(1000){ i ->
            println("I'm Sleeping $i ...")
            delay(500)
        }
    }
}