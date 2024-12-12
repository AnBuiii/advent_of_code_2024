fun main() {
    val inputs = readInput("Day05")
    val manual = mutableMapOf<Int, MutableSet<Int>>()
    var isSplit = false

    val pages = mutableListOf<List<Int>>()
    for (input in inputs) {
        if (isSplit) {
            val value = input.split(",").map(String::toInt)
            pages.add(value)
            continue
        }

        if (input == "") {
            isSplit = true
            continue
        }

        val value = input.split('|').map(String::toInt)
        if (manual[value[0]] == null) {
            manual[value[0]] = mutableSetOf(value[1])
        } else {
            manual[value[0]]?.add(value[1])
        }
    }

    var rs = 0

    here@ for (page in pages) {
        val travelledPage = mutableListOf<Int>()
        for(it in page) {
            if (manual[it] != null && contain(manual[it]!!.toList(), travelledPage)) {
                continue@here
            }
            travelledPage.add(it)
        }

        rs += (page[page.size / 2])
    }

    println(rs)

}

fun contain(l1: List<Int>, l2: List<Int>): Boolean {
    l2.forEach {
        if (l1.contains(it)) {
            return true
        }
    }
    return false
}