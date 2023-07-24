package com.example.eqtest.domain.equalizer

import android.util.Log
import com.example.eqtest.domain.equalizer.coefs.FirCoefficients
import com.example.eqtest.domain.equalizer.effects.Chorus
import com.example.eqtest.domain.equalizer.effects.Distortion
import com.example.eqtest.tools.EqConstants
import kotlin.math.pow

object Equalizer {

    //private val chorus = Chorus()
    private val distortion = Distortion()

    var isChorus = false
    var isDistortion = false

    private val filters = List(EqConstants.FILTERS_COUNT) {
        Filter(
            FirCoefficients.FIR[it]
        )
    }

    suspend fun equalization(input: ShortArray): ShortArray {
        var outputSignal = ShortArray(input.size)
        val filterConvolution = Array(filters.size) {
            filters[it].convolutionAsync(input)
        }
        for (i in outputSignal.indices) {
            for (j in 0 until EqConstants.FILTERS_COUNT) {
                outputSignal[i] = (outputSignal[i] + filterConvolution[j].await()[i]).toShort()
            }
        }
        if (isDistortion){
            distortion.inputStream = outputSignal
            outputSignal = distortion.createEffectAsync().await()
        }
        return outputSignal
    }

    fun setFilterGain(gain: Double, index: Int) {
        filters[index].gain = if (gain == 0.0) gain else 10.0.pow(gain / 10)
    }

}