package com.example.demo

import org.example.com.example.demo.GameBoardPresenter
import org.example.com.example.demo.Rules
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class RulesTest {
    @Test
    fun testSwitchTokenToX() {
        val rules = Rules()
        val player = "user"
        val token = StringBuilder()

        rules.switchTokenTo(player, token)

        Assertions.assertTrue(token.toString() == "X")
    }

    @Test
    fun testSwitchTokenToO() {
        val rules = Rules()
        val player = "cpu"
        val token = StringBuilder()

        rules.switchTokenTo(player, token)

        Assertions.assertTrue(token.toString() == "O")
    }

    @Test
    fun testValidPiecePlacement() {
        val presenter = GameBoardPresenter()
        val rules = Rules()
        val input = 3
        val piecePlaced = rules.piecePlacedSuccessfully(input)

        Assertions.assertTrue(piecePlaced)
    }

    @Test
    fun testInvalidPiecePlacementTooBig() {
        val presenter = GameBoardPresenter()
        val rules = Rules()
        val input = 12
        val piecePlaced = rules.piecePlacedSuccessfully(input)

        Assertions.assertFalse(piecePlaced)
    }

    @Test
    fun testInvalidPiecePlacementTooSmall() {
        val presenter = GameBoardPresenter()
        val rules = Rules()
        val input = 0
        val piecePlaced = rules.piecePlacedSuccessfully(input)

        Assertions.assertFalse(piecePlaced)
    }
}