import kotlin.streams.toList

/**
 *
 *  https://www.baeldung.com/kotlin/aggregate-operations
 *  @date 2022-12-14
 */

fun main() {
    val numbers = listOf(1, 15, 3, 8)
    val count = numbers.count()  // 4
    val sum = numbers.sum()  // 27
    val average = numbers.average() // 6.75
    val sumBy = numbers.sumOf { it * 5 } // 135
    val sumByDouble = numbers.sumOf { it.toDouble() / 8 } // 3.375
//    val min1 = numbers.min() // 1
//    val max1 = numbers.max() // 15 Both functions return null if there are no elements in the collection.
//    val min2 = numbers.minOrNull() // 1
//    val max2 = numbers.maxOrNull() // 15
//    val maxBy = numbers.maxBy { it % 5 } // 3
//    val minBy = numbers.minBy { it % 5 } // 15

    println("base array = $numbers  count:$count  sum:$sum  average:$average  sumBy:$sumBy  sumByDouble:$sumByDouble")
//    println("base array = $numbers  min1:$min1  max1:$max1  min2:$min2  max2:$max2  maxBy:$maxBy  minBy:$minBy")

    val employees = listOf(Employee("A", 3500, 23), Employee("B", 2000, 30))
    println("Employees salary: ${employees.sumOf { it.salary }}")
    val empAverageAge = employees.sumOf { it.age } / employees.count()
    val empAverageAge2 = employees.stream().map { it.age }.toList().average()
    println("Employees average age: $empAverageAge and $empAverageAge2")

    val strings = listOf("Berlin", "Kolkata", "Prague", "Barcelona")
//    val maxWith = strings.maxWith(compareBy { it.length % 4 })
//    val minWith = strings.minWith(compareBy { it.length % 4 })
//    println("maxWith() = $maxWith     minWith() = $minWith")

    val resultFold = numbers.fold(100) { total, it -> total - it } // 73
    val resultFoldRight = numbers.foldRight(0) { it, total -> total - it } // -27
    println("resultFold = $resultFold     resultFoldRight = $resultFoldRight")

    val result1 = numbers.foldIndexed(100) { index, total, it ->
        if (index.minus(2) >= 0) total - it else total
    }
    val result2 = numbers.foldRightIndexed(100) { index, it, total ->
        if (index.minus(2) >= 0) total - it else total
    }
    println("base array = $numbers  result1 = $result1     result2 = $result2")

    // In this case, the first call to the lambda will be with parameters 8 and 3.
    val resultReduce = numbers.reduce { total, it -> total - it } // -25
    val resultReduceRight = numbers.reduceRight() { it, total -> total - it } // -11
    println("base array = $numbers  resultReduce = $resultReduce  resultReduceRight = $resultReduceRight")

    val result3 = numbers.reduceIndexed { index, total, it ->
        if (index.minus(2) >= 0) total - it else total
    }
    val result4 = numbers.reduceRightIndexed { index, it, total ->
        if (index.minus(2) >= 0) total - it else total
    }
    println("base array = $numbers result3 = $result3  result4 = $result4")

    val numbers2 = listOf(1, 2, 3, 4, 5)
    val resultRunningFold = numbers2.runningFold(0) { total, it -> total + it } // 0, 1, 3, 6, 10, 15
    val resultRunningReduce = numbers2.runningReduce { total, it -> total + it } // 1, 3, 6, 10, 15
    println("base array = $numbers2 resultRunningFold = $resultRunningFold  resultRunningReduce = $resultRunningReduce")
}

data class Employee(val name: String, val salary: Int, val age: Int)