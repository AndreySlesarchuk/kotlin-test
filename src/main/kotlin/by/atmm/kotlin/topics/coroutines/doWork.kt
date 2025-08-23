package by.atmm.kotlin.topics.coroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 *  @author Andrei Slesarchuk
 *  @date 2025-08-23
 */

suspend fun main(){

    doWork()

    println("Hello Coroutines")
}
suspend fun doWork()= coroutineScope{
    launch{
        for(i in 0..5){
            println(i)
            delay(400L)
        }
    }
}