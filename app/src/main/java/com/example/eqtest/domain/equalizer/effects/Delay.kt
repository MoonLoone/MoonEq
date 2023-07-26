package com.example.eqtest.domain.equalizer.effects

import com.example.eqtest.tools.EqConstants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async

class Delay(input: ShortArray) : Effect() {

    override var inputStream: ShortArray = input.copyOfRange(0,BUFFER_SIZE)

    override suspend fun createEffectAsync() = CoroutineScope(Dispatchers.IO).async {
        for (i in inputStream.indices){
            inputStream[i] = (inputStream[i] * ATTENUATION).toInt().toShort()
        }
        inputStream
    }

    private companion object{
        const val ATTENUATION: Double = 0.7
        const val BUFFER_SIZE: Int = EqConstants.BUFFER_SIZE / 2
    }

}