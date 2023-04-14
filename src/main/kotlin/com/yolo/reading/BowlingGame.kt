package com.yolo.reading

class BowlingGame {
    private var bowls: MutableList<Int> = mutableListOf()
    fun hit(bowl: Int) {
        bowls.add(bowl)
    }

    fun getScoreForFirstFrame(): Int {
        if (isStrike() || isSpare()) {
            return bowls[0] + bowls[1] + bowls[2]
        }
        return bowls[0] + bowls[1]
    }

    private fun isSpare() = bowls[0] + bowls[1] == 10

    private fun isStrike() = bowls[0] == 10

}
