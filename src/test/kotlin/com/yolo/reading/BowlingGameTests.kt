package com.yolo.reading

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class BowlingGameTests {

    @Test
    fun `should return 0 when hit 0 twice`() {
        BowlingGame().run {
            this.hit(bowl = 0)
            this.hit(bowl = 0)
            assertEquals(0, this.getScoreForFirstFrame())
        }
    }

    @Test
    fun `should return 3 when hit 1 and 2`() {
        BowlingGame().run {
            this.hit(bowl = 1)
            this.hit(bowl = 2)
            assertEquals(3, this.getScoreForFirstFrame())
        }
    }

    @Test
    fun `should return 15 when hit 3, 7 and 5`() {
        BowlingGame().run {
            this.hit(bowl = 3)
            this.hit(bowl = 7)
            this.hit(bowl = 5)
            this.hit(bowl = 3)
            assertEquals(15, this.getScoreForFirstFrame())
        }
    }

    @Test
    fun `should return 17 when hit 10, 5 and 2`() {
        BowlingGame().run {
            this.hit(bowl = 10)
            this.hit(bowl = 5)
            this.hit(bowl = 2)
            assertEquals(17, this.getScoreForFirstFrame())
        }
    }
}