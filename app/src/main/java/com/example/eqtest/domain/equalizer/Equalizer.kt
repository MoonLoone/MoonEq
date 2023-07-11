package com.example.eqtest.domain.equalizer

import com.example.eqtest.domain.equalizer.coefs.IIRCoefficients

object Equalizer {

    private val filters = listOf(
        Filter(
            IIRCoefficients.firstIIR
        ),
        Filter(
            IIRCoefficients.secondIIR
        ),
        Filter(
            IIRCoefficients.thirdIIR
        ),
        Filter(
            IIRCoefficients.fourthIIR
        ),
        Filter(
            IIRCoefficients.fifthIIR
        ),
        Filter(
            IIRCoefficients.sixIIR
        ),
    )

    fun equalization(input: Array<Double>) {
        val filterConvolution = Array(filters.size) {
            filters[it].convolution(input)
        }
        for (i in input.indices) {
            input[i] =
                input[i] + filterConvolution[0][i] + filterConvolution[1][i] + filterConvolution[2][i] + +filterConvolution[3][i] + filterConvolution[4][i] + filterConvolution[5][i]
        }
    }

    fun setFilterGain(gain: Double, index: Int){
        filters[index].gain = gain
    }

}