package by.atmm.kotlin.topics.collections

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-09-08
 */

interface MyList<T> {
    fun get(index: Int): T
    fun add(string: T)
    fun remove(element: T)
    fun removeAt(index: Int)
    fun size(): Int
}