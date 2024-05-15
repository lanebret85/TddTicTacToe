package org.example.com.example.demo

class GameBoardPresenter {
    fun printBoard(gameBoard: GameBoard): String {
        val boardArray = gameBoard.generateBoard(gameBoard.size)
        var prettyBoard = ""
        var innerIndex = 0
        for ((outerIndex, i) in boardArray.withIndex()) {
            for (j in i) {
                prettyBoard += j
                if (innerIndex + 1 < gameBoard.size) {
                    prettyBoard += "|"
                } else if (outerIndex + 1 < gameBoard.size) {
                    prettyBoard += "\n"
                }
                innerIndex ++
            }
            if (outerIndex + 1 < gameBoard.size) {
                for (i in 1..gameBoard.size) {
                    prettyBoard += "-"
                    if (i < gameBoard.size) {
                        prettyBoard += "+"
                    }
                }
                prettyBoard += "\n"
            }
            innerIndex = 0
        }
        return prettyBoard
    }

    fun placePiece(input: Int): String {
        return if (input in 1..9) {
            "Success"
        } else {
            "Invalid space. Try again."
        }
    }

    fun updateBoard(): Int {
//        placeholder: changes the physical space on the board
//        returns the integer representation of that space
        return 0
    }

    fun assignSpaceToPlayer() {
//        placeholder: adds the integer return value from updateBoard to the correct player's list of spaces chose
        return Unit
    }
}