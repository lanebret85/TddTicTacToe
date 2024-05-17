package com.example.demo

import org.example.com.example.demo.Rules
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class RulesTest {
    @Test
    fun testSwitchTokenToX() {
        val rules = Rules()
        val player = "user"
        val token = StringBuilder()

        rules.switchTokenTo(player, token)

        Assertions.assertTrue(token.toString() == "X")
    }

    @Test
    fun testSwitchTokenToO() {
        val rules = Rules()
        val player = "cpu"
        val token = StringBuilder()

        rules.switchTokenTo(player, token)

        Assertions.assertTrue(token.toString() == "O")
    }
}