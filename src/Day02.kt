fun main() {
    // test if implementation meets criteria from the description, like:
    val testInput = readInput("../inputs/Day02_test")
    check(part1(testInput) == 15)
    check(part2(testInput) == 12)

    val input = readInput("../inputs/Day02")
    println(part1(input))
    println(part2(input))
}

private fun part1(input: List<String>): Int {
    var points = 0

    for(line in input)
    {
        if(line.contains('A'))
        {
            println("Enemy played Rock")
            if(line.contains('X'))
            {
                println("You played Rock")
                points += 1 + 3

            }else if(line.contains('Y'))
            {
                println("You played Paper")
                points += 2 + 6
            } else if(line.contains('Z'))
            {
                println("You played Scissors")
                points += 3
            }

        }else if(line.contains('B'))
        {
            println("Enemy played Paper")
            if(line.contains('X'))
            {
                println("You played Rock")
                points += 1 + 0

            }else if(line.contains('Y'))
            {
                println("You played Paper")
                points += 2 + 3
            } else if(line.contains('Z'))
            {
                println("You played Scissors")
                points += 3 + 6
            }
        } else if(line.contains('C'))
        {
            println("Enemy played Scissors")
            if(line.contains('X'))
            {
                println("You played Rock")
                points += 1 + 6

            }else if(line.contains('Y'))
            {
                println("You played Paper")
                points += 2 + 0
            } else if(line.contains('Z'))
            {
                println("You played Scissors")
                points += 3 + 3
            }
        }
    }

    return points
}

private fun part2(input: List<String>): Int {
    var points = 0

    for(line in input)
    {
        if(line.contains('A'))
        {
            println("Enemy played Rock")
            if(line.contains('X'))
            {
                println("You lost. You played Scissors")
                points += 3

            }else if(line.contains('Y'))
            {
                println("You draw. You played Rock")
                points += 1 + 3
            } else if(line.contains('Z'))
            {
                println("You win. You played Paper")
                points += 2 + 6
            }

        }else if(line.contains('B'))
        {
            println("Enemy played Paper")
            if(line.contains('X'))
            {
                println("You lost. You played Rock")
                points += 1 + 0

            }else if(line.contains('Y'))
            {
                println("You draw. You played Paper")
                points += 2 + 3
            } else if(line.contains('Z'))
            {
                println("You won. You played Scissors")
                points += 3 + 6
            }
        } else if(line.contains('C'))
        {
            println("Enemy played Scissors")
            if(line.contains('X'))
            {
                println("You lost. You played Paper")
                points += 2 + 0

            }else if(line.contains('Y'))
            {
                println("You draw. You played Scissors")
                points += 3 + 3
            } else if(line.contains('Z'))
            {
                println("You won. You played Rock")
                points += 1 + 6
            }
        }
    }

    return points
}