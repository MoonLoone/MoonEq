package com.example.eqtest.domain.equalizer

class IIR(val numinatorCoefficients: Array<Double>, val denominatorCoefficients: Array<Double>) :
    Filter {

    override var gain: Double = 1.0

    override fun convolution(input: ShortArray): ShortArray {
        var accumulator: Double = .0
        val output = ShortArray(input.size) { 0 }
        for (i in input.indices) {
            accumulator = .0
            for (j in 0..minOf(i, numinatorCoefficients.size - 1)) {
                accumulator += input[i - j] * numinatorCoefficients[j]
                for (k in 0..minOf(i, denominatorCoefficients.size - 1)) {
                    accumulator -= input[i - j] * denominatorCoefficients[j]
                }
            }
            output[i] = (gain * accumulator * 0.25).toInt().toShort()
        }
        return output
    }

}