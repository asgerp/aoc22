fun main() {
    fun calcScore(elf: String, you: String): Int {
        var points = when (elf) {
            // rock
            "A" -> {
                when (you) {
                    "X" -> 3
                    "Y" -> 6
                    "Z" -> 0
                    else -> {
                        0
                    }
                }
            }
            // paper
            "B" -> {
                when (you) {
                    "X" -> 0
                    "Y" -> 3
                    "Z" -> 6
                    else -> {
                        0
                    }
                }
            }
            // scissors
            "C" -> {
                when (you) {
                    "X" -> 6
                    "Y" -> 0
                    "Z" -> 3
                    else -> {
                        0
                    }
                }
            }
            else -> {
                0
            }
        }

        points += when (you) {
            "X" -> 1 // rock
            "Y" -> 2 // paper
            "Z" -> 3 // scissor
            else -> {
                0
            }
        }

        return points
    }

    fun calcNewScore(elf: String, you: String): Int {
        var points = when (you) {
            "X" -> 0 // loss
            "Y" -> 3 // draw
            "Z" -> 6 // win
            else -> {
                0
            }
        }
        points += when (elf) {
            // rock
            "A" -> {
                when (you) {
                    "X" -> 3 // loss -> scissor
                    "Y" -> 1 // draw -> rock
                    "Z" -> 2 // win -> paper
                    else -> {
                        0
                    }
                }
            }
            // paper
            "B" -> {
                when (you) {
                    "X" -> 1 // loss -> rock
                    "Y" -> 2 // draw -> paper
                    "Z" -> 3 // win -> scissor
                    else -> {
                        0
                    }
                }
            }
            // scissors
            "C" -> {
                when (you) {
                    "X" -> 2 // loss -> paper
                    "Y" -> 3 // draw -> scissor
                    "Z" -> 1 // win -> rock
                    else -> {
                        0
                    }
                }
            }
            else -> {
                0
            }
        }

        return points
    }

    fun part1(input: List<String>): Int {
        var points = 0
        for (l in input) {
            points += calcScore(l.substring(0, 1), l.substring(2, 3))
        }
        return points
    }

    fun part2(input: List<String>): Int {
        var points = 0
        for (l in input) {
            points += calcNewScore(l.substring(0, 1), l.substring(2, 3))
        }
        return points
    }



    // test if implementation meets criteria from the description, like:
    //val testInput = readInput("Day01_test")
    //check(part1(testInput) == 1)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
