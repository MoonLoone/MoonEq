package com.example.eqtest.domain.equalizer

import com.example.eqtest.domain.equalizer.coefs.IIRCoefficients

object Equalizer {

    private const val FILTER_ORDER = 15

    private val filters = listOf(
        Filter(
            FILTER_ORDER,
            IIRCoefficients.firstIIR
        ),
        Filter(
            FILTER_ORDER,
            IIRCoefficients.secondIIR
        ),
        Filter(
            FILTER_ORDER,
            IIRCoefficients.thirdIIR
        ),
        Filter(
            FILTER_ORDER,
            IIRCoefficients.fourthIIR
        ),
        Filter(
            FILTER_ORDER,
            IIRCoefficients.fifthIIR
        ),
        Filter(
            FILTER_ORDER,
            IIRCoefficients.sixIIR
        ),
    )

    fun equalization(input: Array<Double>) {
        val filterConvolution = Array(filters.size) {
            filters[it].convolution(input)
        }
        val result = Array(input.size) { 0.0 }
        for (i in input.indices) {
            input[i] =
                input[i] + filterConvolution[0][i] + filterConvolution[1][i] + filterConvolution[2][i] + +filterConvolution[3][i] + filterConvolution[4][i] + filterConvolution[5][i]
        }
    }

}