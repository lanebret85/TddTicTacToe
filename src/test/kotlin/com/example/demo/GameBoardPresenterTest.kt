package com.example.demo

import org.example.com.example.demo.GameBoard
import org.example.com.example.demo.GameBoardPresenter
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class GameBoardPresenterTest {
    @Test
    fun testPrintBoard() {
        val gameBoard = GameBoard(3)
        val presenter = GameBoardPresenter(gameBoard)

        Assertions.assertNotNull(presenter.printBoard(gameBoard))
        Assertions.assertTrue(presenter.printBoard(gameBoard).length == (((gameBoard.size * 2) - 1) * ((gameBoard.size * 2) - 1) + ((gameBoard.size * 2) - 2)))
    }

    @Test
    fun testValidPiecePlacement() {
        val gameBoard = GameBoard(3)
        val presenter = GameBoardPresenter(gameBoard)
        val input = 3
        val piecePlaced = presenter.placePiece(input)

        Assertions.assertTrue(piecePlaced == "Success")
    }

    @Test
    fun testInvalidPiecePlacementTooBig() {
        val gameBoard = GameBoard(3)
        val presenter = GameBoardPresenter(gameBoard)
        val input = 12
        val piecePlaced = presenter.placePiece(input)

        Assertions.assertTrue(piecePlaced == "Invalid space. Try again.")
    }

    @Test
    fun testInvalidPiecePlacementTooSmall() {
        val gameBoard = GameBoard(3)
        val presenter = GameBoardPresenter(gameBoard)
        val input = 0
        val piecePlaced = presenter.placePiece(input)

        Assertions.assertTrue(piecePlaced == "Invalid space. Try again.")
    }
}