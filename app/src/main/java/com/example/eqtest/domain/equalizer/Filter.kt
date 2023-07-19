package com.example.eqtest.domain.equalizer

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
            var accumulator: Int
            val output = input.clone()
            for (i in input.indices) {
                accumulator = 0
                for (j in coefficients.indices) {
                    if (i-j >= 0) accumulator += input[i-j] * coefficients[j]
                    if (gain == 1.0) output[i] = (output[i] + (0.145 * accumulator.toShort()).toInt()).toShort()
                    else output[i] = (output[i] + (0.13 * gain * accumulator).toInt()).toShort()
                }
            }
            return@async output
        }
}