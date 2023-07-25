package com.example.eqtest.domain.equalizer

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async

class Filter(
    private val coefficients: Array<Double>,
) {

    var gain: Double = 1.0

    fun convolutionAsync(input: ShortArray): ShortArray {
            var accumulator: Double = .0
            val output = ShortArray(input.size) { 0 }
            for (i in input.indices) {
                accumulator = .0
                for (j in 0..minOf(i, coefficients.size - 1)) {
                    accumulator += input[i - j] * coefficients[j]
                }
                output[i] = (gain * accumulator * 0.125).toInt().toShort()
            }
            return output
        }
}