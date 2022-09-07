package by.atmm.kotlin.topics.classes.transport

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-09-07
 */

abstract class Transport(open val name: String) {
    abstract fun drive()
}