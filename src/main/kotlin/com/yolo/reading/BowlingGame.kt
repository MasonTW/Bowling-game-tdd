package com.yolo.reading

class BowlingGame {
    private var bowls: MutableList<Int> = mutableListOf()
    fun hit(bowl: Int) {
        bowls.add(bowl)
    }

    fun getScoreForFirstFrame(): Int {
        if (isStrike() || isSpare(frame = 1)) {
            return bowls[0] + bowls[1] + bowls[2]
        }
        return bowls[0] + bowls[1]
    }

    private fun isSpare(frame: Int) = (frame-1).run {
        bowls[this*2] + bowls[this*2+1] == 10
    }

    private fun isStrike() = bowls[0] == 10

    fun getScoreForSecondFrame(): Int {
        if (isSpare(frame = 2)) {
            return bowls[2] + bowls[3] + bowls[4]
        }
        return bowls[2] + bowls[3]
    }

}
