import kotlin.math.absoluteValue
import kotlin.math.sign

fun main() {
    val input = readInput("Day02")
    var result = 0

    outloop@for (str in input) {
        val list = str.split(" ").map { it.toInt() }.toMutableList()
        for (i in list.indices) {
            val  newList  = list.filterIndexed { index, _ -> index != i }
            if(check(newList)) {
                result++
                continue@outloop
            }
        }

    }

    println(result)
}


fun check(list: List<Int>): Boolean {
    var check = 0


    for (i in 0..<list.lastIndex) {
        val temp = list[i] - list[i + 1]
        if (temp == 0) return false
        if (check == 0) {
            check = temp.sign
        } else if (check != temp.sign) {
            return false
        }

        if (temp.absoluteValue > 3) {
            return false
        }
    }
    return true
}
