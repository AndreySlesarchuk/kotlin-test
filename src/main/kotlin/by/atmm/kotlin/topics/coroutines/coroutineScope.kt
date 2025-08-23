package by.atmm.kotlin.topics.coroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 *  @author Andrei Slesarchuk
 *  @date 2025-08-23
 */

suspend fun main() = coroutineScope {
    launch{
        for(i in 0..5){
            delay(400L)
            println(i)
        }
    }
    launch{
        for(i in 6..10){
            delay(400L)
            println(i)
        }
    }
    println("Done")
}