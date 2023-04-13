package com.yolo.reading

class BowlingGame {
    private var scores = 0
    fun hit(bowl: Int) {
        scores += bowl
    }

    fun getScoreForFirstFrame(): Int {
        return scores
    }

}
