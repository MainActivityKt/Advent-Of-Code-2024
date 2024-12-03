import kotlin.math.abs

fun List<Int>.isReportValid(): Boolean {
    val sorted = this.sorted()
    val sortedDesc = this.sortedDescending()
    if (sorted() != this && sortedDescending() != this) {
        return false
    }
    forEachIndexed { index, i ->
        if (index != lastIndex && abs(i - get(index + 1)) !in 1..3) {
            return false
        }
    }
    return true
}

fun countValidReports(reportList: List<String>): Int {
    var validReports = 0
    reportList.forEach { row ->
        val numericValues = row.split(' ').map{ it.toInt() }
        if (numericValues.isReportValid()) {
            println(numericValues.joinToString(" "))
            validReports++
        }
    }
    return validReports
}

fun main() {
    fun part1(input: List<String>): Int {
        println(countValidReports(input))
        return countValidReports(input)
    }

    fun part2(input: List<String>): Int {
        return -1
    }

    val testInput = readInput("Day02_test")
    check(part1(testInput) == 2)

    check(part2(testInput) == -1)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}