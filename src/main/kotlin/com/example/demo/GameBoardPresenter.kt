package org.example.com.example.demo

class GameBoardPresenter {
    fun printBoard(gameBoard: Array<Array<String>>) {
        println(boardToString(gameBoard))
    }

    fun boardToString(gameBoard: Array<Array<String>>): String {
        val prettyBoard = StringBuilder()
        var innerIndex = 0
        for ((outerIndex, i) in gameBoard.withIndex()) {
            for (j in i) {
                addSpace(prettyBoard, j)
                if (innerIndex + 1 < gameBoard.size) {
                    addColDivider(prettyBoard)
                } else if (outerIndex + 1 < gameBoard.size) {
                    addLineBreak(prettyBoard)
                }
                innerIndex++
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

    fun printPrompt() {
        println(promptUser())
    }

    fun promptUser(): String {
        return "Select a space to place your piece: "
    }
}