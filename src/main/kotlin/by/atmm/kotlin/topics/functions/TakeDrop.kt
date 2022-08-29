import topics.showListWithHeader

fun main() {
    val array = (0..100).toList()
    val employees = array.map { "Employee № $it" }
    val first30 = employees.take(30)
    showListWithHeader("take 30 : ", first30)
    val last30 = employees.drop(30)
    showListWithHeader("drop 30 : ", last30)

}