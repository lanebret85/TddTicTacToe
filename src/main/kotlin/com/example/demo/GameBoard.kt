package org.example.com.example.demo

class GameBoard (val size: Int) {
    private var boardArray: Array<Array<String>> = Array(size) { Array(size) { " " } }

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

    fun assignSpaceToPlayer(space: Int, playerPositions: MutableList<Int>) {
        playerPositions.add(space)
    }

    fun generateWinConditions(size: Int): List<List<Int>> {
        val lastSpace = size * size
        val range: List<Int> = (1..lastSpace).toList()
        val winConditions: MutableList<List<Int>> = mutableListOf()

        generateRowWinConditions(size, range, winConditions)
        generateColWinConditions(size, range, winConditions)
        generateCross1WinCondition(size, range, winConditions)
        generateCross2WinCondition(size, range, winConditions)

        return winConditions
    }

    private fun generateRowWinConditions(size: Int, range: List<Int>, winConditions: MutableList<List<Int>>) {
        for (i in 0 until size) {
            val conditions: MutableList<Int> = mutableListOf()
            for (j in 0 until size) {
                conditions += range[j + (i * size)]
            }
            addConditionToWinConditions(winConditions, conditions)
        }
    }

    private fun generateColWinConditions(size: Int, range: List<Int>, winConditions: MutableList<List<Int>>) {
        for (i in 0 until size) {
            val conditions = mutableListOf<Int>()
            for (j in 0 until size) {
                val index = (j * size) + i
                conditions += range[index]
            }
            addConditionToWinConditions(winConditions, conditions)
        }
    }

    private fun generateCross1WinCondition(size: Int, range: List<Int>, winConditions: MutableList<List<Int>>) {
        val condition = mutableListOf<Int>()
        for (i in 0 until size) {
            val index = i * (size + 1)
            condition += range[index]
        }
        addConditionToWinConditions(winConditions, condition)
    }

    private fun generateCross2WinCondition(size: Int, range: List<Int>, winConditions: MutableList<List<Int>>) {
        val condition = mutableListOf<Int>()
        for (i in 0 until size) {
            val index = (i * (size - 1)) + (size - 1)
            condition += range[index]
        }
        addConditionToWinConditions(winConditions, condition)
    }

    private fun addConditionToWinConditions(winConditions: MutableList<List<Int>>, conditions: MutableList<Int>) {
        winConditions.add(conditions.toList())
        conditions.clear()
    }
}