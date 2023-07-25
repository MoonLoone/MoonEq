package com.example.eqtest.domain.equalizer

import android.util.Log
import com.example.eqtest.domain.equalizer.coefs.FirCoefficients
import com.example.eqtest.domain.equalizer.effects.Chorus
import com.example.eqtest.domain.equalizer.effects.Distortion
import com.example.eqtest.tools.EqConstants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlin.coroutines.coroutineContext
import kotlin.math.pow

object Equalizer {

    private val chorus = Chorus()
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
            CoroutineScope(coroutineContext).async { filters[it].convolutionAsync(input) }
        }
        for (i in input.indices) {
            for (j in filters.indices) {
                outputSignal[i] = (outputSignal[i] + filterConvolution[j].await()[i]).toShort()
            }
        }
        if (isChorus){
            chorus.inputStream = outputSignal
            outputSignal = chorus.createEffectAsync().await()
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