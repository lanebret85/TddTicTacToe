package org.example.com.example.demo

class Rules {
    val playerPositions = mutableListOf<Int>()
    val cpuPositions = mutableListOf<Int>()

    fun switchTokenTo(user: String, token: StringBuilder) {
        when (user) {
            "player" -> {
                token.clear()
                token.append("X")
            }
            "cpu" -> {
                token.clear()
                token.append("O")
            }
        }
    }

    fun piecePlacedSuccessfully(input: Int): Boolean {
        return input in 1..9
    }

    fun isWinner(gameBoard: GameBoard, user: String): Boolean {
        for(condition in gameBoard.generateWinConditions()) {
            when (user) {
                "player" -> if (playerPositions.containsAll(condition)) {
                    return true
                }
                "cpu" -> if (cpuPositions.containsAll(condition)) {
                    return true
                }
            }
        }
        return false
    }

    fun isDraw(gameBoard: GameBoard): Boolean {
        return playerPositions.size + cpuPositions.size == gameBoard.size * gameBoard.size
    }
}