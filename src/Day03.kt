import kotlin.io.path.Path
import kotlin.io.path.readText

fun main() {
    val text = Path("src/Day03.txt").readText()
    val regex = Regex("""mul\((\d{1,3}),(\d{1,3})\)|don't\(\)|do\(\)""")

    val matches =  regex.findAll(text)
    var rs = 0
    matches.forEach {
        println(it.groupValues)
        val x = it.groupValues[1].toInt()
        val y = it.groupValues[2].toInt()
        rs += x * y
    }
    println(rs)

}