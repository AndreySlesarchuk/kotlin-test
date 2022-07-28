package by.atmm.kotlin.topics

import kotlinx.coroutines.*
import java.lang.Thread.sleep
import kotlin.concurrent.thread

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-07-09
 */

fun main() {
    test01()
    test02()
}

fun test01() = runBlocking { // this: CoroutineScope
    launch { // launch a new coroutine and continue
        delay(1000L) // non-blocking delay for 1 second (default time unit is ms)
        println("World!") // print after delay
    }
    print("Hello, ") // main coroutine continues while a previous one is delayed
}

fun test02() = runBlocking { // this: CoroutineScope
    thread { // launch a new coroutine and continue
        sleep(1000L) // non-blocking delay for 1 second (default time unit is ms)
        println("World!") // print after delay
    }
    print("Hello ") // main coroutine continues while a previous one is delayed
}
