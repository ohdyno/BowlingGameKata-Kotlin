package me.ohdyno.katas.BowlingGame

import org.testng.Assert.assertEquals
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

class BowlingGameTest {
    private lateinit var game: Game

    @BeforeMethod
    fun setUp() {
        game = Game()
    }

    @Test fun testGutterGame() {
        game.rollMany(n = 20, pins = 0)
        assertEquals(game.score, 0)
    }

    @Test
    fun testAllOnes() {
        game.rollMany(n = 20, pins = 1)
        assertEquals(game.score, 20)
    }

    @Test
    fun testOneSpare() {
        game.rollSpare()
        game.roll(3)
        game.rollMany(n = 17, pins = 0)
        assertEquals(game.score, 16)
    }

    @Test
    fun testOneStrike() {
        game.rollStrike()
        game.roll(3)
        game.roll(4)
        game.rollMany(16, 0)
        assertEquals(game.score, 24)
    }

    @Test
    fun testPerfectGame() {
        game.rollMany(n = 12, pins = 10)
        assertEquals(game.score, 300)
    }

    private fun Game.rollMany(n: Int, pins: Int) {
        (1..n).forEach { this.roll(pins) }
    }

    private fun Game.rollSpare() {
        this.roll(5)
        this.roll(5)
    }

    private fun Game.rollStrike() {
        this.roll(10)
    }

}

