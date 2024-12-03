import kotlin.math.absoluteValue

fun main() {
    val input = readInput("Day01")
    val list1 = mutableListOf<Int>()
    val list2 = mutableListOf<Int>()

    input.forEach {
        val a = it.split("   ")
        list1.add(a[0].toInt())
        list2.add(a[1].toInt())
    }

    list1.sort()
    list2.sort()

    var result = 0
    for (i in list1.indices) {
        result += (list1[i] - list2[i]).absoluteValue
    }
    println(result)
}


