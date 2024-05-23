package org.example.com.example.demo

class Rules {
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

    fun isWinner(gameBoard: GameBoard, userConditions: List<Int>): Boolean {
        for(condition in gameBoard.generateWinConditions()) {
            if (userConditions.containsAll(condition)) {
                return true
            }
        }
        return false
    }
}