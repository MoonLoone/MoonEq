package com.example.eqtest.domain.equalizer

class Filter(
    private val filterOrder: Int,
    private val coefficients: Array<Double>,
) {

    var gain: Double = 1.0

    fun convolution(input: Array<Double>): Array<Double> {
        return Array(input.size){0.0}
    }

}