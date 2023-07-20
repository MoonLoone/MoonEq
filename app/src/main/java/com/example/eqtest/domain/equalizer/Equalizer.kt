package com.example.eqtest.domain.equalizer

import com.example.eqtest.domain.equalizer.coefs.FirCoefficients
import com.example.eqtest.tools.EqConstants

object Equalizer {

    private val filters = List(EqConstants.FILTERS_COUNT){
        Filter(
            FirCoefficients.FIR[it]
        )
    }

    suspend fun equalization(input: ShortArray) {
        val filterConvolution = Array(filters.size) {
            filters[it].convolutionAsync(input)
        }
        for (i in input.indices) {
            input[i] =
                (input[i] + filterConvolution[0].await()[i] + filterConvolution[1].await()[i] + filterConvolution[2].await()[i] + +filterConvolution[3].await()[i] + filterConvolution[4].await()[i] + filterConvolution[5].await()[i]).toShort()
        }
    }

    fun setFilterGain(gain: Double, index: Int) {
        filters[index].gain = gain
    }

}