import kotlin.math.abs

fun getListOfPairDistances(input: List<String>): Pair<ArrayList<Int>, ArrayList<Int>> {
    val leftSideValues = arrayListOf<Int>()
    val rightSideValues = arrayListOf<Int>()
    input.forEach {
        it.split(' ').apply {
            leftSideValues.add(first().toInt())
            rightSideValues.add(last().toInt())
        }
    }
   return leftSideValues to rightSideValues
}

fun calculateTotalDistance(pairDistances: Pair<ArrayList<Int>, ArrayList<Int>>): Int {
    val sortedLeftSideList = pairDistances.first.sorted()
    val sortedRightSideList = pairDistances.second.sorted()
    return sortedLeftSideList.zip(sortedRightSideList) { r, l -> abs(r - l) }.sum()
}

fun calculateSimilarityScores(pairDistances: Pair<ArrayList<Int>, ArrayList<Int>>): List<Int> {
    val leftSideList = pairDistances.first
    val rightSideList = pairDistances.second

    val similarityDistances = leftSideList.map { l -> l * rightSideList.count { r -> r == l } }
    return similarityDistances
}


fun main() {
    fun part1(input: List<String>): Int {
        val listPair = getListOfPairDistances(input)
        return calculateTotalDistance(listPair)
    }

    fun part2(input: List<String>): Int {
        val listPair = getListOfPairDistances(input)
        return calculateSimilarityScores(listPair).sum()
    }

    val testInput = readInput("Day01_test")
    check(part1(testInput) == 11)

    check(part2(testInput) == 31)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
