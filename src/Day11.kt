fun main() {
    val testInput = readInput("../inputs/Day11_test")
    val input = readInput("../inputs/Day11")
    // println(part1(testInput))
    // println(part1(input))
    println(part2(testInput))
    println(part2(input))
}
enum class OperationType {
    ADD, MUL, ADDOLD, MULOLD
}
class Monkey(var items: MutableList<Long>, val operator: Long, val operation: OperationType, val test: Long, val true_target: Int, val false_target: Int, var monkeyBusiness: Long) {
    public fun testItems(targets: MutableList<Monkey>) {
        val iterate = items.listIterator()
        while(iterate.hasNext()) {
            var currItem = iterate.next()
            when(operation) {
                OperationType.ADD -> currItem += operator
                OperationType.MUL -> currItem *= operator
                OperationType.ADDOLD -> currItem += currItem
                OperationType.MULOLD -> currItem *= currItem
            }
            currItem = currItem.floorDiv(3L);

            if (currItem % test == 0L) {
                targets[true_target].items.add(currItem)
            } else {
                targets[false_target].items.add(currItem)
            }
            monkeyBusiness++
        }
        items = mutableListOf()
    }

    public fun testItems2(targets: MutableList<Monkey>, modulo: Long) {
        val iterate = items.listIterator()
        while(iterate.hasNext()) {
            var currItem = iterate.next()
            when(operation) {
                OperationType.ADD -> currItem += operator
                OperationType.MUL -> currItem *= operator
                OperationType.ADDOLD -> currItem += currItem
                OperationType.MULOLD -> currItem *= currItem
            }

            currItem %= modulo

            if (currItem % test == 0L) {
                targets[true_target].items.add(currItem)
            } else {
                targets[false_target].items.add(currItem)
            }
            monkeyBusiness++
        }
        items = mutableListOf()
    }
}
private fun part1(input: List<String>): Long {
    var monkeyList = mutableListOf<Monkey>()

    val iterate = input.listIterator()
    for (i in 0..input.size step 7) {
        iterate.next()
        val tItems = iterate.next().removePrefix("  Starting items: ").split(", ").map { it.toLong() }.toMutableList()

        val tOperatorString = iterate.next().removePrefix("  Operation: new = old ").split(" ").toList()
        var tOperator = 0.toLong()
        var tOperation = OperationType.ADD
        if (tOperatorString[1] == "old") {
            tOperator = 0.toLong()
            tOperation = if (tOperatorString[0] == "+") {
                OperationType.ADDOLD
            } else {
                OperationType.MULOLD
            }
        } else {
            tOperator = tOperatorString[1].toLong()
            tOperation = if (tOperatorString[0] == "+") {
                OperationType.ADD
            } else {
                OperationType.MUL
            }
        }

        val tTest = iterate.next().removePrefix("  Test: divisible by ").toLong()

        val tTrueTarget = iterate.next().removePrefix("    If true: throw to monkey ").toInt()
        val tFalseTarget = iterate.next().removePrefix("    If false: throw to monkey ").toInt()

        if (iterate.hasNext()) {
            iterate.next()
        }

        var monkey = Monkey(tItems, tOperator, tOperation, tTest, tTrueTarget, tFalseTarget, 0.toLong())
        monkeyList.add(monkey)
    }

    for (i in 1..20) {
        for (monkey in monkeyList) {
            monkey.testItems(monkeyList)
        }
    }

    var sumMonkeyBusiness = mutableListOf<Long>()
    for (monkey in monkeyList) {
        sumMonkeyBusiness.add(monkey.monkeyBusiness)
    }

    sumMonkeyBusiness.sort()
    sumMonkeyBusiness.reverse()

    return (sumMonkeyBusiness[0] * sumMonkeyBusiness[1])
}

private fun part2(input: List<String>): Long {
    var monkeyList = mutableListOf<Monkey>()

    val iterate = input.listIterator()
    for (i in 0..input.size step 7) {
        iterate.next()
        val tItems = iterate.next().removePrefix("  Starting items: ").split(", ").map { it.toLong() }.toMutableList()

        val tOperatorString = iterate.next().removePrefix("  Operation: new = old ").split(" ").toList()
        var tOperator = 0.toLong()
        var tOperation = OperationType.ADD
        if (tOperatorString[1] == "old") {
            tOperator = 0.toLong()
            tOperation = if (tOperatorString[0] == "+") {
                OperationType.ADDOLD
            } else {
                OperationType.MULOLD
            }
        } else {
            tOperator = tOperatorString[1].toLong()
            tOperation = if (tOperatorString[0] == "+") {
                OperationType.ADD
            } else {
                OperationType.MUL
            }
        }

        val tTest = iterate.next().removePrefix("  Test: divisible by ").toLong()

        val tTrueTarget = iterate.next().removePrefix("    If true: throw to monkey ").toInt()
        val tFalseTarget = iterate.next().removePrefix("    If false: throw to monkey ").toInt()

        if (iterate.hasNext()) {
            iterate.next()
        }

        var monkey = Monkey(tItems, tOperator, tOperation, tTest, tTrueTarget, tFalseTarget, 0.toLong())
        monkeyList.add(monkey)
    }
    
    var accuracy = 1L
    for (monkey in monkeyList) {
        accuracy *= monkey.test
    }

    for (i in 1..10000) {
        for (monkey in monkeyList) {
            monkey.testItems2(monkeyList, accuracy)
        }
    }

    var sumMonkeyBusiness = mutableListOf<Long>()
    for (monkey in monkeyList) {
        sumMonkeyBusiness.add(monkey.monkeyBusiness)
    }

    sumMonkeyBusiness.sort()
    sumMonkeyBusiness.reverse()

    return (sumMonkeyBusiness[0] * sumMonkeyBusiness[1])
}
