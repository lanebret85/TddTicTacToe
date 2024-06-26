package com.example.demo

import org.example.com.example.demo.GameBoard
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

// take in n number of rows/cols - done
// generate win conditions for n number of rows/cols - done
// give player option to play again after any result (win, lose, or tie)
// play on "hard mode" where computer is unbeatable (find algorithm)
// be specific in naming, including assigning name for symbols that make up the board with a pretty print UI class
// be able to place a piece 'X' or 'O'

class GameBoardTest {
    @Test
    fun testCreateBoardWithSize3() {
        val gameBoard = GameBoard(3)
        val generatedBoard = gameBoard.generateBoard(gameBoard.size)
        val checkBoard: Array<Array<String>> = arrayOf(
            arrayOf(" ", " ", " "),
            arrayOf(" ", " ", " "),
            arrayOf(" ", " ", " ")
        )

        Assertions.assertTrue(checkBoard contentDeepEquals generatedBoard)
    }

    @Test
    fun testCreateBoardWithSize5() {
        val gameBoard = GameBoard(5)
        val generatedBoard = gameBoard.generateBoard(gameBoard.size)
        val checkBoard: Array<Array<String>> = arrayOf(
            arrayOf(" ", " ", " ", " ", " "),
            arrayOf(" ", " ", " ", " ", " "),
            arrayOf(" ", " ", " ", " ", " "),
            arrayOf(" ", " ", " ", " ", " "),
            arrayOf(" ", " ", " ", " ", " ")
        )

        Assertions.assertTrue(checkBoard contentDeepEquals generatedBoard)
    }

    @Test
    fun testGenerateWinConditionsForBoardWithSize3() {
        val gameBoard = GameBoard(3)
        val row1 = listOf(1, 2, 3)
        val row2 = listOf(4, 5, 6)
        val row3 = listOf(7, 8, 9)
        val col1 = listOf(1, 4, 7)
        val col2 = listOf(2, 5, 8)
        val col3 = listOf(3, 6, 9)
        val cross1 = listOf(1, 5, 9)
        val cross2 = listOf(3, 5, 7)
        val n3WinConditions: List<List<Int>> = listOf(
            row1,
            row2,
            row3,
            col1,
            col2,
            col3,
            cross1,
            cross2
        )

        Assertions.assertTrue(n3WinConditions == gameBoard.generateWinConditions(gameBoard.size))
    }

    @Test
    fun testGenerateWinConditionsForBoardWithSize5() {
        val gameBoard = GameBoard(5)
        val row1 =listOf(1, 2, 3, 4, 5)
        val row2 = listOf(6, 7, 8, 9, 10)
        val row3 = listOf(11, 12, 13, 14, 15)
        val row4 = listOf(16, 17, 18, 19, 20)
        val row5 = listOf(21, 22, 23, 24, 25)
        val col1 = listOf(1, 6, 11, 16, 21)
        val col2 = listOf(2, 7, 12, 17, 22)
        val col3 = listOf(3, 8, 13, 18, 23)
        val col4 = listOf(4, 9, 14, 19, 24)
        val col5 = listOf(5, 10, 15, 20, 25)
        val cross1 = listOf(1, 7, 13, 19, 25)
        val cross2 = listOf(5, 9, 13, 17, 21)
        val n5WinConditions: List<List<Int>> = listOf(
            row1,
            row2,
            row3,
            row4,
            row5,
            col1,
            col2,
            col3,
            col4,
            col5,
            cross1,
            cross2
        )

        Assertions.assertTrue(n5WinConditions == gameBoard.generateWinConditions(gameBoard.size))
    }
}