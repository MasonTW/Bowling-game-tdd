package com.yolo.reading
class BowlingGame {
    private var bowls: MutableList<Int?> = mutableListOf()
    fun hit(bowl: Int) {
        bowls.add(bowl)
        if (bowl == 10){
            bowls.add(null)
        }
    }

    fun getScoreByFrame(frame: Int): Int {
        val startIndex = getIndexByFrame(frame)
        if (isStrike(frame) || isSpare(frame)) {
            return getStrikeOrSpareScore(startIndex)
        }
        return bowls[startIndex]!! + bowls[startIndex + 1]!!
    }

    private fun getStrikeOrSpareScore(startIndex: Int): Int {
        var sum = 0
        var count = 0
        var index = startIndex
        while (count < 3 && index < bowls.size) {
            bowls[index].let {
                if (it != null) {
                    sum += it
                    count++
                }
                index++
            }
        }
        return sum
    }


    private fun isSpare(frame: Int) = getIndexByFrame(frame).run {
        bowls[this]!! + bowls[this + 1]!! == 10
    }

    private fun getIndexByFrame(frame: Int) = COUNT_OF_EACH_FRAME * (frame - 1)

    private fun isStrike(frame: Int) = getIndexByFrame(frame).run {
        bowls[this] == 10
    }

    companion object {
        const val COUNT_OF_EACH_FRAME = 2
    }

}

