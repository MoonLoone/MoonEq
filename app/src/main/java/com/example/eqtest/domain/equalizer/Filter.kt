package com.example.eqtest.domain.equalizer

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async

class Filter(
    private val coefficients: Array<Double>,
) {

    var gain: Double = 1.0

    fun convolutionAsync(input: Array<Double>): Deferred<Array<Double>> =
        CoroutineScope(Dispatchers.IO).async {
            var accumulator: Int
            val output = input.clone()
            for (i in output.indices) {
                for (j in coefficients.indices) {
                    accumulator = (output[i] * coefficients[j]).toInt()
                    if (gain == 1.0) output[i] += 0.145 * accumulator.toDouble()
                    else output[i] += 0.13 * gain * accumulator.toDouble()
                }
            }
            return@async output
        }
}