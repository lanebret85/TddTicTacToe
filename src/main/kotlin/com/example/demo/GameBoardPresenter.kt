package org.example.com.example.demo

class GameBoardPresenter {
    fun printBoard(gameBoard: GameBoard) {
        println(boardToString(gameBoard.generateBoard(gameBoard.size)))
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

    fun piecePlacedSuccessfully(input: Int): Boolean {
        return input in 1..9
    }

    fun userInputs(value: Int): Int {
        return value
    }

    fun printPrompt() {
        println(promptUser())
    }

    fun promptUser(): String {
        return "Select a space to place your piece: "
    }

    fun updateBoard(gameBoard: Array<Array<String>>, token: StringBuilder, space: Int): String {
        val boardSize = gameBoard.size
        val outerIndex = (space - 1) / boardSize
        val innerIndex = (space - 1) - (outerIndex * boardSize)
        gameBoard[outerIndex][innerIndex] = token.toString()

        return boardToString(gameBoard)
    }

    fun assignSpaceToPlayer() {
//        placeholder: adds the integer return value from updateBoard to the correct player's list of spaces chose
    }
}