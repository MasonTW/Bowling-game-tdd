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
}