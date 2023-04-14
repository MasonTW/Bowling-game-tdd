package com.yolo.reading

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class BowlingGameTests {

    @Test
    fun `should return 0 when hit 0 twice`() {
        BowlingGame().run {
            this.hit(bowl = 0)
            this.hit(bowl = 0)
            assertEquals(0, this.getScoreByFrame(1))
        }
    }

    @Test
    fun `should return 3 when hit 1 and 2`() {
        BowlingGame().run {
            this.hit(bowl = 1)
            this.hit(bowl = 2)
            assertEquals(3, this.getScoreByFrame(1))
        }
    }

    @Test
    fun `should return 15 when hit 3, 7 and 5`() {
        BowlingGame().run {
            this.hit(bowl = 3)
            this.hit(bowl = 7)
            this.hit(bowl = 5)
            this.hit(bowl = 3)
            assertEquals(15, this.getScoreByFrame(1))
        }
    }

    @Test
    fun `should return 17 when hit 10, 5 and 2`() {
        BowlingGame().run {
            this.hit(bowl = 10)
            this.hit(bowl = 5)
            this.hit(bowl = 2)
            assertEquals(17, this.getScoreByFrame(1))
        }
    }

    @Test
    fun `should return second score when hit normal twice`() {
        BowlingGame().run {
            this.hit(bowl = 1)
            this.hit(bowl = 2)
            this.hit(bowl = 3)
            this.hit(bowl = 4)
            assertEquals(3, this.getScoreByFrame(1))
            assertEquals(7, this.getScoreByFrame(2))

        }
    }

    @Test
    fun `should return second score when hit spare in the second`() {
        BowlingGame().run {
            this.hit(bowl = 1)
            this.hit(bowl = 2)
            this.hit(bowl = 3)
            this.hit(bowl = 7)
            this.hit(bowl = 5)
            assertEquals(3, this.getScoreByFrame(1))
            assertEquals(15, this.getScoreByFrame(2))

        }
    }

    @Test
    fun `should return second score when hit strike in the second`() {
        BowlingGame().run {
            this.hit(bowl = 1)
            this.hit(bowl = 2)
            this.hit(bowl = 10)
            this.hit(bowl = 5)
            this.hit(bowl = 2)
            assertEquals(3, this.getScoreByFrame(1))
            assertEquals(17, this.getScoreByFrame(2))

        }
    }

    @Test
    fun `should return second score when hit spare twice`() {
        BowlingGame().run {
            this.hit(bowl = 2)
            this.hit(bowl = 8)
            this.hit(bowl = 1)
            this.hit(bowl = 9)
            this.hit(bowl = 2)
            assertEquals(11, this.getScoreByFrame(1))
            assertEquals(12, this.getScoreByFrame(2))

        }
    }


    @Test
    fun `should return second score when hit spare and strike`() {
        BowlingGame().run {
            this.hit(bowl = 2)
            this.hit(bowl = 8)
            this.hit(bowl = 10)
            this.hit(bowl = 1)
            this.hit(bowl = 2)
            assertEquals(20, this.getScoreByFrame(1))
            assertEquals(13, this.getScoreByFrame(2))

        }
    }

    @Test
    fun `should return second score when hit strike and spare`() {
        BowlingGame().run {
            this.hit(bowl = 10)
            this.hit(bowl = 5)
            this.hit(bowl = 5)
            this.hit(bowl = 3)
            assertEquals(20, this.getScoreByFrame(1))
            assertEquals(13, this.getScoreByFrame(2))

        }
    }

    @Test
    fun `should return 30 in every frame when all strike`() {
        BowlingGame().run {
            repeat(12) { this.hit(bowl = 10) }

            repeat(10) {
                assertEquals(30, this.getScoreByFrame(it + 1))
            }
        }
    }

    @Test
    fun `should return 300 when all strike`() {
        BowlingGame().run {
            repeat(12) { this.hit(bowl = 10) }

            assertEquals(300, this.getTotalScore())
        }
    }

    @Test
    fun `should return 150 when all spare`() {
        BowlingGame().run {
            repeat(21) { this.hit(bowl = 5) }

            assertEquals(150, this.getTotalScore())
        }
    }

    @Test
    fun `should return 80 total score when all hit 4`() {
        BowlingGame().run {
            repeat(20) { this.hit(bowl = 4) }

            assertEquals(80, this.getTotalScore())
        }
    }

    @Test
    fun `should correct total score`() {
        val hitList = listOf(10, 7, 3, 9, 0, 10, 0, 8, 8, 2, 0, 6, 10, 10, 10, 10, 10)
        BowlingGame().run {
            hitList.forEach {
                this.hit(it)
            }
            assertEquals(180, this.getTotalScore())
        }
    }

}