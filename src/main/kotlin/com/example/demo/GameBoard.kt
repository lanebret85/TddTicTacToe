package org.example.com.example.demo

class GameBoard (val size: Int) {
    private var boardArray: Array<Array<String>> = Array(size) { Array(size) { " " } }
    private var winConditions: MutableList<List<Int>> = mutableListOf()

    fun generateBoard(): Array<Array<String>> {
        return boardArray
    }

    fun updateBoard(token: StringBuilder, space: Int): Array<Array<String>> {
        val boardSize = size
        val outerIndex = (space - 1) / boardSize
        val innerIndex = (space - 1) - (outerIndex * boardSize)
        boardArray[outerIndex][innerIndex] = token.toString()

        return boardArray
    }

    fun assignSpaceToUser(space: Int, userPositions: MutableList<Int>) {
        userPositions.add(space)
    }

    fun generateWinConditions(): List<List<Int>> {
        val lastSpace = size * size
        val range: List<Int> = (1..lastSpace).toList()

        generateRowWinConditions(range)
        generateColWinConditions(range)
        generateCross1WinCondition(range)
        generateCross2WinCondition(range)

        return winConditions
    }

    private fun generateRowWinConditions(range: List<Int>) {
        for (i in 0 until size) {
            val conditions: MutableList<Int> = mutableListOf()
            for (j in 0 until size) {
                conditions += range[j + (i * size)]
            }
            addConditionToWinConditions(conditions)
        }
    }

    private fun generateColWinConditions(range: List<Int>) {
        for (i in 0 until size) {
            val conditions = mutableListOf<Int>()
            for (j in 0 until size) {
                val index = (j * size) + i
                conditions += range[index]
            }
            addConditionToWinConditions(conditions)
        }
    }

    private fun generateCross1WinCondition(range: List<Int>) {
        val condition = mutableListOf<Int>()
        for (i in 0 until size) {
            val index = i * (size + 1)
            condition += range[index]
        }
        addConditionToWinConditions(condition)
    }

    private fun generateCross2WinCondition(range: List<Int>) {
        val condition = mutableListOf<Int>()
        for (i in 0 until size) {
            val index = (i * (size - 1)) + (size - 1)
            condition += range[index]
        }
        addConditionToWinConditions(condition)
    }

    private fun addConditionToWinConditions(conditions: MutableList<Int>) {
        winConditions.add(conditions.toList())
        conditions.clear()
    }
}