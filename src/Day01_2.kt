fun main() {
    val input = readInput("Day01")
    val list1 = mutableListOf<Int>()
    val list2 = mutableListOf<Int>()

    input.forEach {
        val a = it.split("   ")
        list1.add(a[0].toInt())
        list2.add(a[1].toInt())
    }

    val grouped2 = list2.groupingBy { it }.eachCount()

    var result = 0
    list1.forEach {
        result += it * (grouped2[it] ?: 0)
    }
    println(result)
}