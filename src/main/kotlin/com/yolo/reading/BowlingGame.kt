package com.yolo.reading

class BowlingGame {
    private var bowls: MutableList<Int?> = mutableListOf()
    fun hit(bowl: Int) {
        bowls.add(bowl)
        fixWhenStrike(bowl)
    }

    fun getScoreByFrame(frame: Int): Int {
        val startIndex = getIndexByFrame(frame)
        if (isStrike(frame) || isSpare(frame)) {
            return getStrikeOrSpareScore(startIndex, 3)
        }
        return getStrikeOrSpareScore(startIndex, 2)
    }

    private fun getStrikeOrSpareScore(startIndex: Int, count: Int): Int {
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

