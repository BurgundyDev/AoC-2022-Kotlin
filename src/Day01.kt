fun main() {
    fun part1(input: List<String>): Int {
        var currentElf: Int = 0
        val elfs = mutableListOf<Int>()

        for(line in input)
        {
            if(line.isNotEmpty())
            {
                currentElf += line.toInt()
            }else
            {
                elfs.add(currentElf)
                currentElf = 0
            }
        }
        elfs.add(currentElf)

        return elfs.max()
    }

    fun part2(input: List<String>): Int {
        var currentElf: Int = 0
        val elfs = mutableListOf<Int>()

        for(line in input)
        {
            if(line.isNotEmpty())
            {
                currentElf += line.toInt()
            }else
            {
                elfs.add(currentElf)
                currentElf = 0
            }
        }
        elfs.add(currentElf)

        elfs.sort()
        elfs.reverse()

        return elfs.take(3).sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("../inputs/Day01_test")
    check(part1(testInput) == 24000)
    check(part2(testInput) == 45000)

    val input = readInput("../inputs/Day01")
    println(part1(input))
    println(part2(input))
}
