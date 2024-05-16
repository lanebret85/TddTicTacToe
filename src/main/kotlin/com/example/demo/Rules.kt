package org.example.com.example.demo

class Rules {
    fun switchTokenTo(player: String, token: StringBuilder) {
        when (player) {
            "user" -> {
                token.clear()
                token.append("X")
            }
            "cpu" -> {
                token.clear()
                token.append("O")
            }
        }
    }
}