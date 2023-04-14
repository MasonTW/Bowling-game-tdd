package com.yolo.reading

class BowlingGame {
    private var bowls: MutableList<Int?> = mutableListOf()
    fun getTotalScore(): Int {
        var totalScore = 0
        repeat(10) {
            totalScore += getScoreByFrame(it + 1)
        }
        return totalScore
    }

    fun hit(bowl: Int) {
        bowls.add(bowl)
        fixWhenStrike(bowl)
    }

    fun getScoreByFrame(frame: Int): Int {
        val startIndex = getIndexByFrame(frame)
        if (isStrike(frame) || isSpare(frame)) {
            return getScore(startIndex, 3)
        }
        return getScore(startIndex, 2)
    }

    private fun getScore(startIndex: Int, count: Int): Int {
        var sum = 0
        var currentCount = 0
        var index = startIndex
        while (currentCount < count && index < bowls.size) {
            bowls[index].let {
                if (it != null) {
                    sum += it
                    currentCount++
                }
                index++
            }
        }
        return sum
    }


    private fun isSpare(frame: Int): Boolean {
        val index = getIndexByFrame(frame)
        val first = bowls[index]
        val second = bowls[index + 1]
        return if (first == null || second == null) false
        else first + second == 10
    }

    private fun getIndexByFrame(frame: Int) = COUNT_OF_EACH_FRAME * (frame - 1)

    private fun isStrike(frame: Int) = getIndexByFrame(frame).run {
        bowls[this] == 10
    }

    private fun fixWhenStrike(bowl: Int) {
        if (bowl == 10) {
            bowls.add(null)
        }
    }

    companion object {
        const val COUNT_OF_EACH_FRAME = 2
    }

}

