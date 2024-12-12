fun main() {
    val inputs = readInput("Day04").map(String::toList)
    var rs = 0

    for (i in 0..inputs.size - 3) {
        for (y in 0..inputs[i].size - 3) {
            val d1 = listOf(inputs[i][y], inputs[i + 1][y + 1], inputs[i + 2][y + 2])
            val d2 = listOf(inputs[i + 2][y], inputs[i + 1][y + 1], inputs[i][y + 2])
            if (isxMas(d1, d2)) {
                rs++
            }
        }
    }
    println(rs)
}

private val mas = listOf('M', 'A', 'S')
private val sam = listOf('S', 'A', 'M')
fun isxMas(d1: List<Char>, d2: List<Char>): Boolean {
    return (d1 == sam || d1 == mas) && (d2 == sam || d2 == mas)
}