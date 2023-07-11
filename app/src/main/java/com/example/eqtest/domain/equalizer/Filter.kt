package com.example.eqtest.domain.equalizer

class Filter(
    private val coefficients: Array<Double>,
) {

    var gain: Double = 1.0

    fun convolution(input: Array<Double>): Array<Double> {
        var accumulator: Int
        val output = input.clone()
        for (i in output.indices) {
            for (j in coefficients.indices) {
                accumulator = (output[i] * coefficients[j]).toInt()
                if (gain == 1.0) output[i] += 0.145 * accumulator.toDouble()
                else output[i + j] += 0.13 * gain * accumulator.toDouble()
            }
        }
        return output
    }

}