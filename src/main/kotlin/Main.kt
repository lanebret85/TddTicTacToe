package org.example

import org.example.com.example.demo.GameBoard
import org.example.com.example.demo.GameBoardPresenter
import org.example.com.example.demo.Rules
import java.util.*

fun main() {
    val board = GameBoard(3)
    val presenter = GameBoardPresenter()
    val rules = Rules()
    val token = StringBuilder()
    val scanner = Scanner(System.`in`)
    var playerPosition = 0
    val playerPositions = mutableListOf<Int>()

    presenter.printBoard(board.generateBoard())
    presenter.printPrompt()
    rules.switchTokenTo("user", token)
    playerPosition = scanner.nextInt()
    if (rules.piecePlacedSuccessfully(playerPosition)) {
        board.assignSpaceToUser(playerPosition, playerPositions)
        presenter.printBoard(board.updateBoard(token, playerPosition))
    }
}