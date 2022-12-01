fun main() {
    fun groupElves(input: List<String>): MutableList<Int> {
        var currentElf: Int = 0
        val elves = mutableListOf<Int>()

        for(line in input)
        {
            if(line.isNotEmpty())
            {
                currentElf += line.toInt()
            }else
            {
                elves.add(currentElf)
                currentElf = 0
            }
        }
        elves.add(currentElf)
        return elves
    }

    fun part1(input: List<String>): Int {
        val elves = groupElves(input)

        return elves.max()
    }

    fun part2(input: List<String>): Int {
        val elves = groupElves(input)
        
        elves.sort()
        elves.reverse()

        return elves.take(3).sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("../inputs/Day01_test")
    check(part1(testInput) == 24000)
    check(part2(testInput) == 45000)

    val input = readInput("../inputs/Day01")
    println(part1(input))
    println(part2(input))
}
