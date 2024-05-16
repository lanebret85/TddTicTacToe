package org.example.com.example.demo

class GameBoardPresenter {
    fun printBoard(gameBoard: GameBoard): String {
        val boardArray = gameBoard.generateBoard(gameBoard.size)
        val prettyBoard = StringBuilder()
        var innerIndex = 0
        for ((outerIndex, i) in boardArray.withIndex()) {
            for (j in i) {
                addSpace(prettyBoard, j)
                if (innerIndex + 1 < gameBoard.size) {
                    addColDivider(prettyBoard)
                } else if (outerIndex + 1 < gameBoard.size) {
                    addLineBreak(prettyBoard)
                }
                innerIndex ++
            }
            if (outerIndex + 1 < gameBoard.size) {
                for (i in 1..gameBoard.size) {
                    addRowDivider(prettyBoard)
                    if (i < gameBoard.size) {
                        addIntersection(prettyBoard)
                    }
                }
                addLineBreak(prettyBoard)
            }
            innerIndex = 0
        }
        return prettyBoard.toString()
    }

    private fun addSpace(gameBoardRepresentation: StringBuilder, space: String) {
        gameBoardRepresentation.append(space)
    }

    private fun addColDivider(gameBoardRepresentation: StringBuilder) {
        gameBoardRepresentation.append("|")
    }

    private fun addLineBreak(gameBoardRepresentation: StringBuilder) {
        gameBoardRepresentation.append("\n")
    }

    private fun addRowDivider(gameBoardRepresentation: StringBuilder) {
        gameBoardRepresentation.append("-")
    }

    private fun addIntersection(gameBoardRepresentation: StringBuilder) {
        gameBoardRepresentation.append("+")
    }

    fun placePiece(input: Int): String {
        return if (input in 1..9) {
            "Success"
        } else {
            "Invalid space. Try again."
        }
    }

    fun placePiece(): Int {

    }

    fun updateBoard() {
//        placeholder: changes the physical space on the board
//        returns the integer representation of that space
    }

    fun assignSpaceToPlayer() {
//        placeholder: adds the integer return value from updateBoard to the correct player's list of spaces chose
        return Unit
    }
}