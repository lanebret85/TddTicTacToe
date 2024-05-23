package com.example.demo

import org.example.com.example.demo.GameBoard
import org.example.com.example.demo.Rules
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class RulesTest {
    @Test
    fun testSwitchTokenToX() {
        val rules = Rules()
        val player = "player"
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
        val rules = Rules()
        val input = 3
        val piecePlaced = rules.piecePlacedSuccessfully(input)

        Assertions.assertTrue(piecePlaced)
    }

    @Test
    fun testInvalidPiecePlacementTooBig() {
        val rules = Rules()
        val input = 12
        val piecePlaced = rules.piecePlacedSuccessfully(input)

        Assertions.assertFalse(piecePlaced)
    }

    @Test
    fun testInvalidPiecePlacementTooSmall() {
        val rules = Rules()
        val input = 0
        val piecePlaced = rules.piecePlacedSuccessfully(input)

        Assertions.assertFalse(piecePlaced)
    }

    @Test
    fun testIsWinnerTrue() {
        val gameBoard = GameBoard(3)
        val rules = Rules()
        val playerPositions = listOf(1, 2, 3)

        Assertions.assertTrue(rules.isWinner(gameBoard, playerPositions))
    }

    @Test
    fun testIsWinnerFalse() {
        val gameBoard = GameBoard(3)
        val rules = Rules()
        val playerPositions = listOf(1, 2, 4)

        Assertions.assertFalse(rules.isWinner(gameBoard, playerPositions))
    }

    @Test
    fun testIsDrawFalse() {
        val gameBoard = GameBoard(3)
        val rules = Rules()
        val playerPositions = listOf(2, 3)
        val cpuPositions = listOf(4, 5, 7)

        Assertions.assertFalse(rules.isDraw(gameBoard, playerPositions, cpuPositions))
    }

    @Test
    fun testIsDrawTrue() {
        val gameBoard = GameBoard(3)
        val rules = Rules()
        val playerPositions = listOf(1, 3, 4, 8, 9)
        val cpuPositions = listOf(2, 5, 6, 7)

        Assertions.assertTrue(rules.isDraw(gameBoard, playerPositions, cpuPositions))
    }
}