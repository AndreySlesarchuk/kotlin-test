package by.atmm.kotlin.topics.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 *  @author Andrei Slesarchuk
 *  @date 2025-08-23
 */

fun main() = runBlocking {
    launch {
        for (x in 1..5) {
            delay(400L)
            println(x)
        }
    }
    println("Done")
}