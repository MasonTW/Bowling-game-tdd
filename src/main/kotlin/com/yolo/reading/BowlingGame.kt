package com.yolo.reading

class BowlingGame {
    private var bowls: MutableList<Int> = mutableListOf()
    fun hit(bowl: Int) {
        bowls.add(bowl)
    }

    fun getScoreForFirstFrame(frame: Int = 1): Int {
        var startIndex = getIndexByFrame(frame)
        if (isStrike(frame) || isSpare(frame)) {
            return bowls[startIndex] + bowls[startIndex + 1] + bowls[startIndex + 2]
        }
        return bowls[startIndex] + bowls[startIndex + 1]
    }

    private fun isSpare(frame: Int) = getIndexByFrame(frame).run {
        bowls[this] + bowls[this + 1] == 10
    }

    private fun getIndexByFrame(frame: Int) = COUNT_OF_EACH_FRAME * (frame - 1)

    private fun isStrike(frame: Int) = getIndexByFrame(frame).run {
        bowls[this] == 10
    }

    fun getScoreForSecondFrame(frame: Int = 2): Int {
        var startIndex = getIndexByFrame(frame)
        if (isStrike(frame) || isSpare(frame)) {
            return bowls[startIndex] + bowls[startIndex + 1] + bowls[startIndex + 2]
        }
        return bowls[startIndex] + bowls[startIndex + 1]
    }

    companion object {
        const val COUNT_OF_EACH_FRAME = 2
    }

}
