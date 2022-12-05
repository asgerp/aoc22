fun main() {
    fun solve(lines: List<String>): List<Int> {
        val cals = mutableListOf<Int>()
        var currentCal = 0
        for (l in lines) {
            if (l.isBlank()) {
                cals.add(currentCal)
                currentCal = 0
            } else {
                currentCal += l.toInt()
            }
        }
        return cals
    }

    fun part1(input: List<String>): Int {
        val res = solve(input)
        return res.max()
    }

    fun part2(input: List<String>): Int {
        val res = solve(input)
        return res.sortedDescending().take(3).sum()
    }



    // test if implementation meets criteria from the description, like:
    //val testInput = readInput("Day01_test")
    //check(part1(testInput) == 1)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
