import kotlin.math.abs

fun List<Int>.isReportValid(): Boolean {
    if (!isSorted()) {
        return false
    }
    forEachIndexed { index, i ->
        if (index != lastIndex && abs(i - get(index + 1)) !in 1..3) {
            return false
        }
    }
    return true
}

fun List<Int>.isSorted(): Boolean {
    return this == sorted() || this == sortedDescending()
}

fun countValidReports(reportList: List<String>, tolerateError: Boolean = false): Int {
    var validReports = 0
    reportList.forEach { row ->
        val numericValues = row.split(' ').map{ it.toInt() }
        if (tolerateError && numericValues.isReportValidWithTolerate() || numericValues.isReportValid()) {

            validReports++
        }
    }
    return validReports
}

fun List<Int>.isReportValidWithTolerate(): Boolean {
    if (isReportValid()) {
        return true
    }
    for (i in 0..lastIndex) {
        val reportWithoutElementIndex = filterIndexed { index, _ -> index != i }
        if (reportWithoutElementIndex.isReportValid()) {
            return true
        }
    }
    return false
}

fun main() {
    fun part1(input: List<String>): Int {
        return countValidReports(input)
    }

    fun part2(input: List<String>): Int {
        return countValidReports(input, true)
    }

    val testInput = readInput("Day02_test")
   // check(part1(testInput) == 2)

   check(part2(testInput) == 4)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day02")
    println("Part 1:")
    part1(input).println()
    println("Part 2:")
    part2(input).println()
}