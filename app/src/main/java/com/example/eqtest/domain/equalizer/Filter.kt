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

    fun convolutionAsync(input: ShortArray): Deferred<ShortArray> =
        CoroutineScope(Dispatchers.IO).async {
            var accumulator: Double = .0
            val output = ShortArray(input.size){0}
            for (i in input.indices) {
                accumulator = .0
                for (j in coefficients.indices) {
                    if (i - j >= 0) accumulator += input[i-j] * coefficients[j]
                }
                output[i] = (0.145 * gain * accumulator).toInt().toShort()
            }
            return@async output
        }
}