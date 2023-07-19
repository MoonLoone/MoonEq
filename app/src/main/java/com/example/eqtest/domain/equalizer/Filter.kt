package com.example.eqtest.domain.equalizer

import android.util.Log
import com.example.eqtest.tools.shortArrayToByteArray
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async

class Filter(
    private val coefficients: Array<Double>,
) {

    var gain: Double = 0.0

    fun convolutionAsync(input: ShortArray): Deferred<ShortArray> =
        CoroutineScope(Dispatchers.IO).async {
            var accumulator: Int
            val output = ShortArray(input.size)
            for (i in 0 until input.size - coefficients.size) {
                for (j in coefficients.indices) {
                    accumulator = (input[i] * coefficients[j]).toInt()
                    if (gain == 1.0) output[i+j] = (output[i+j] + (0.145 * accumulator)).toInt().toShort()
                    else output[i+j] = (output[i+j] + (0.13 * gain * accumulator).toInt()).toShort()
                }
            }
            return@async output
        }
}