package com.example.eqtest.domain.equalizer

import com.example.eqtest.domain.equalizer.coefs.FirCoefficients
import com.example.eqtest.domain.equalizer.coefs.IIRCoefficients
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
    var isFIR = false

    private val FIRFilters = List(EqConstants.FILTERS_COUNT) {
        FIR(
            FirCoefficients.FIR[it]
        )
    }

    private val IIRFilters = List(EqConstants.FILTERS_COUNT) {
        IIR(
            numinatorCoefficients = IIRCoefficients.numinatorCoefficients[it],
            denominatorCoefficients = IIRCoefficients.denominatorCoefficients[it],
        )
    }

    private var filters: List<Filter> = FIRFilters

    suspend fun equalization(input: ShortArray): ShortArray {
        var outputSignal = ShortArray(input.size)
        val filterConvolution = Array(filters.size) {
            CoroutineScope(coroutineContext).async { filters[it].convolution(input) }
        }
        for (i in input.indices) {
            for (j in filters.indices) {
                outputSignal[i] = (outputSignal[i] + filterConvolution[j].await()[i]).toShort()
            }
        }
        if (isChorus) {
            chorus.inputStream = outputSignal
            outputSignal = chorus.createEffectAsync().await()
        }
        if (isDistortion) {
            distortion.inputStream = outputSignal
            outputSignal = distortion.createEffectAsync().await()
        }
        return outputSignal
    }

    fun setFilterGain(gain: Double, index: Int) {
        filters[index].gain = if (gain == 0.0) gain else 10.0.pow(gain / 10)
    }

    fun changeFilterType() {
        filters = if (isFIR) FIRFilters else IIRFilters
    }

}