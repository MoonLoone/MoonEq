package com.example.eqtest.domain.equalizer

class FIR(
    private val coefficients: Array<Double>,
) : Filter {

    override var gain: Double = 1.0

    override fun convolution(input: ShortArray): ShortArray {
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