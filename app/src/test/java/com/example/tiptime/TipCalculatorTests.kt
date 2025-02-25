package com.example.tiptime

import junit.framework.TestCase.assertEquals
import org.junit.Test
import java.text.NumberFormat


class TipCalculatorTests {

    @Test
    fun calculateTip_20PercentNoRoundup() {

        val amount = 10.00
        val tipPercent = 20.00
        val expectedAmount = NumberFormat.getCurrencyInstance().format(2)
        val actualTip = calculateTip(amount = amount, tipPercent = tipPercent, roundUp = false)
        assertEquals(expectedAmount, actualTip)

    }

    @Test
    fun calculateTip_1000PercentNoRoundUp() {
        val amount = 100.00
        val tipPercent = 1000.00
        val exceptedAmount = NumberFormat.getCurrencyInstance().format(100)
        val actualtip = calculateTip(amount = amount, tipPercent = tipPercent, roundUp = false)
        assertEquals(exceptedAmount, actualtip)
    }

}

private fun calculateTip(amount: Double, tipPercent: Double = 15.0, roundUp: Boolean): String {
    val isValidationPercent = tipPercent.coerceIn(0.0, 100.0)
    var tip = isValidationPercent / 100 * amount
    if (roundUp) {
        tip = kotlin.math.ceil(tip)
    }
    return NumberFormat.getCurrencyInstance().format(tip)
}
