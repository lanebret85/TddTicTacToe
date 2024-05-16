package org.example

import org.example.com.example.demo.GameBoard
import org.example.com.example.demo.GameBoardPresenter


fun main() {
    val board = GameBoard(3)
    val presenter = GameBoardPresenter()

    presenter.printBoard(board)
    presenter.printPrompt()
}