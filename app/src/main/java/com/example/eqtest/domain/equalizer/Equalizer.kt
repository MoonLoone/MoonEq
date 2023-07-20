package com.example.eqtest.domain.equalizer

import android.util.Log
import com.example.eqtest.domain.equalizer.coefs.FirCoefficients
import com.example.eqtest.tools.EqConstants
import kotlin.math.pow

object Equalizer {

    private val filters = List(EqConstants.FILTERS_COUNT) {
        Filter(
            FirCoefficients.FIR[it]
        )
    }

    suspend fun equalization(input: ShortArray): ShortArray {
        val filterConvolution = Array(filters.size) {
            filters[it].convolutionAsync(input)
        }
        val outputSignal = ShortArray(input.size)
        for (i in outputSignal.indices) {
            for (j in 0 until EqConstants.FILTERS_COUNT) {
                outputSignal[i] = (outputSignal[i] + filterConvolution[j].await()[i]).toShort()
            }
        }
        return outputSignal
    }

    fun setFilterGain(gain: Double, index: Int) {
        filters[index].gain = if (gain == 0.0) gain else 10.0.pow(gain / 10)
    }

}