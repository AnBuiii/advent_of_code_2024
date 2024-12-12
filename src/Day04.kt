fun main() {
    val inputs = readInput("Day04").map(String::toList)
    print(countHorizontal(inputs) + countVertical(inputs) + countLeftDiagonal(inputs) + countRightDiagonal(inputs))
}

fun countHorizontal(inputs: List<List<Char>>): Int {
    var rs = 0
    for (i in inputs.indices) {

        for (y in 0..inputs[i].lastIndex - 3) {
            if (isXmas(inputs[i].subList(y, y + 4))) {
                rs++
            }

        }
    }
    return rs
}

fun countVertical(inputs: List<List<Char>>): Int {
    var rs = 0
    for (i in 0..inputs.lastIndex - 3) {
        for (y in inputs[i].indices) {
            val list = listOf(inputs[i][y], inputs[i + 1][y], inputs[i + 2][y], inputs[i + 3][y])
            if (isXmas(list)) {
                rs++
            }
        }
    }
    return rs
}

fun countLeftDiagonal(inputs: List<List<Char>>): Int {
    var rs = 0
    for (i in 0..inputs.lastIndex - 3) {
        for (y in 0..inputs[i].lastIndex - 3) {
            val list = listOf(inputs[i][y], inputs[i + 1][y + 1], inputs[i + 2][y + 2], inputs[i + 3][y + 3])
            if (isXmas(list)) {
                rs++
            }
        }
    }

    return rs
}

fun countRightDiagonal(inputs: List<List<Char>>): Int {
    var rs = 0

    for (i in 3..inputs.lastIndex) {
        for (y in 0..inputs[i].lastIndex - 3) {
            val list = listOf(
                inputs[i][y],
                inputs[i - 1][y + 1],
                inputs[i - 2][y + 2],
                inputs[i - 3][y + 3]
            )

            if (isXmas(list)) {
                rs++
            }
        }
    }
    return rs
}


private val xmas = listOf('X', 'M', 'A', 'S')
private val samx = listOf('S', 'A', 'M', 'X')
fun isXmas(chars: List<Char>): Boolean {
    return chars == xmas || chars == samx
}