package org.example.com.example.demo

class GameBoard (var size: Int) {
    fun generateBoard(size: Int): Array<Array<String>> {
        val board: Array<Array<String>> = Array(size) { Array(size) { " " } }

        return board
    }

    fun generateWinConditions(size: Int): List<List<Int>> {
        val winConditions: MutableList<List<Int>> = mutableListOf()
        val condition: MutableList<Int> = mutableListOf()
        val lastSpace = size * size
        val range: List<Int> = (1..lastSpace).toList()

//        first n conditions (rows):
        for (i in 0 until size) {
            for (j in 0 until size) {
                condition += range[j + (i * size)]
            }
            winConditions.add(condition.toList())
            condition.clear()
        }
//        next n conditions (cols):
        for (i in 0 until size) {
            for (j in 0 until size) {
                val index = (j * size) + i
                condition += range[index]
            }
            winConditions.add(condition.toList())
            condition.clear()
        }

        for (i in 0 until size) {
            val index = i * (size + 1)
            condition += range[index]
        }
        winConditions.add(condition.toList())
        condition.clear()

        for (i in 0 until size) {
            val index = (i * (size - 1)) + (size - 1)
            condition += range[index]
        }
        winConditions.add(condition.toList())

        return winConditions
    }
}