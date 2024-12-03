import kotlin.math.absoluteValue
import kotlin.math.sign

fun main() {
    val input = readInput("Day02")
    var result = 0;

    outloop@ for (str in input) {
        var check = 0;
        val list = str.split(" ").map { it.toInt() }

        for (i in 0..<list.lastIndex) {
            val temp = list[i] - list[i + 1];
            if (temp == 0) continue@outloop
            if (check == 0) {
                check = temp.sign;
            } else if (check != temp.sign) {
                continue@outloop
            }

            if(temp.absoluteValue >  3) {
                continue@outloop
            }
        }
        result++
    }
    println(result);
}
