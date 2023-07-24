package com.example.eqtest.domain.equalizer.effects

import com.example.eqtest.tools.EqConstants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async

class Distortion : Effect() {

    override var inputStream: ShortArray = ShortArray(EqConstants.BUFFER_SIZE/Short.SIZE_BYTES)

    override suspend fun createEffectAsync() = CoroutineScope(Dispatchers.IO).async {
        for (i in inputStream.indices){
           if (inputStream[i] > UPPER_BOUND)  inputStream[i] =
               (UPPER_BOUND + inputStream[i] * COMPRESSION).toInt().toShort()
           else if (inputStream[i] < LOWER_BOUND) inputStream[i] =
               (LOWER_BOUND + inputStream[i] * COMPRESSION).toInt().toShort()
        }
        inputStream
    }

    private companion object {
        const val UPPER_BOUND: Int = 600
        const val LOWER_BOUND: Int = -200
        const val COMPRESSION: Double = 0.1
    }

}