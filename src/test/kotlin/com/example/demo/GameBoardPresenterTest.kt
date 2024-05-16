package com.example.demo

import org.example.com.example.demo.GameBoard
import org.example.com.example.demo.GameBoardPresenter
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class GameBoardPresenterTest {
    @Test
    fun testBoardToStringBuilder() {
        val gameBoard = GameBoard(3)
        val presenter = GameBoardPresenter()

        Assertions.assertNotNull(presenter.boardToString(gameBoard.generateBoard(gameBoard.size)))
        Assertions.assertTrue(presenter.boardToString(gameBoard.generateBoard(gameBoard.size)).length == (((gameBoard.size * 2) - 1) * ((gameBoard.size * 2) - 1) + ((gameBoard.size * 2) - 2)))
    }

    @Test
    fun testValidPiecePlacement() {
        val presenter = GameBoardPresenter()
        val input = 3
        val piecePlaced = presenter.piecePlacedSuccessfully(input)

        Assertions.assertTrue(piecePlaced)
    }

    @Test
    fun testInvalidPiecePlacementTooBig() {
        val presenter = GameBoardPresenter()
        val input = 12
        val piecePlaced = presenter.piecePlacedSuccessfully(input)

        Assertions.assertFalse(piecePlaced)
    }

    @Test
    fun testInvalidPiecePlacementTooSmall() {
        val presenter = GameBoardPresenter()
        val input = 0
        val piecePlaced = presenter.piecePlacedSuccessfully(input)

        Assertions.assertFalse(piecePlaced)
    }

    @Test
    fun testUserInputs() {
        val presenter = GameBoardPresenter()

        Assertions.assertTrue(presenter.userInputs(1) == 1)
        Assertions.assertTrue(presenter.userInputs(9) == 9)
    }

    @Test
    fun testPromptUser() {
        val presenter = GameBoardPresenter()

        Assertions.assertTrue(presenter.promptUser() == "Select a space to place your piece: ")
    }

    @Test
    fun testUpdateBoard() {
        val presenter = GameBoardPresenter()
        val gameBoard = GameBoard(3)
        val token = StringBuilder("X")
        val space = presenter.userInputs(1)
        val updatedBoard = presenter.updateBoard(gameBoard.generateBoard(gameBoard.size), token, space)

        Assertions.assertTrue(updatedBoard.contains(token))
        Assertions.assertTrue(updatedBoard[0] == token[0])
    }
}