package com.example.demo

import org.example.com.example.demo.GameBoard
import org.example.com.example.demo.GameBoardPresenter
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class GameBoardPresenterTest {
    @Test
    fun testBoardToString() {
        val gameBoard = GameBoard(3)
        val presenter = GameBoardPresenter()

        Assertions.assertNotNull(presenter.boardToString(gameBoard.generateBoard()))
        Assertions.assertTrue(presenter.boardToString(gameBoard.generateBoard()).length == (((gameBoard.size * 2) - 1) * ((gameBoard.size * 2) - 1) + ((gameBoard.size * 2) - 2)))
    }

    @Test
    fun testPromptUser() {
        val presenter = GameBoardPresenter()

        Assertions.assertTrue(presenter.promptUser() == "Select a space to place your piece: ")
    }
}