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
        val user = "player"
        val playerPositions = rules.playerPositions

        gameBoard.assignSpaceToUser(1, playerPositions)
        gameBoard.assignSpaceToUser(2, playerPositions)
        gameBoard.assignSpaceToUser(3, playerPositions)

        Assertions.assertTrue(rules.isWinner(gameBoard, user))
    }

    @Test
    fun testIsWinnerFalse() {
        val gameBoard = GameBoard(3)
        val rules = Rules()
        val user = "player"
        val playerPositions = rules.playerPositions

        gameBoard.assignSpaceToUser(1, playerPositions)
        gameBoard.assignSpaceToUser(2, playerPositions)
        gameBoard.assignSpaceToUser(4, playerPositions)

        Assertions.assertFalse(rules.isWinner(gameBoard, user))
    }

    @Test
    fun testIsDrawFalse() {
        val gameBoard = GameBoard(3)
        val rules = Rules()
        val playerPositions = rules.playerPositions
        val cpuPositions = rules.cpuPositions

        gameBoard.assignSpaceToUser(1, playerPositions)
        gameBoard.assignSpaceToUser(4, cpuPositions)
        gameBoard.assignSpaceToUser(2, playerPositions)
        gameBoard.assignSpaceToUser(5, cpuPositions)
        gameBoard.assignSpaceToUser(9, playerPositions)
        gameBoard.assignSpaceToUser(6, cpuPositions)

        Assertions.assertFalse(rules.isDraw(gameBoard))
    }

    @Test
    fun testIsDrawTrue() {
        val gameBoard = GameBoard(3)
        val rules = Rules()
        val playerPositions = rules.playerPositions
        val cpuPositions = rules.cpuPositions

        gameBoard.assignSpaceToUser(1, playerPositions)
        gameBoard.assignSpaceToUser(2, cpuPositions)
        gameBoard.assignSpaceToUser(3, playerPositions)
        gameBoard.assignSpaceToUser(5, cpuPositions)
        gameBoard.assignSpaceToUser(4, playerPositions)
        gameBoard.assignSpaceToUser(6, cpuPositions)
        gameBoard.assignSpaceToUser(8, playerPositions)
        gameBoard.assignSpaceToUser(7, cpuPositions)
        gameBoard.assignSpaceToUser(9, playerPositions)

        Assertions.assertTrue(rules.isDraw(gameBoard))
    }
}