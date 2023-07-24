package com.example.eqtest.domain.equalizer.effects

import com.example.eqtest.tools.EqConstants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import java.nio.ShortBuffer

class Delay : Effect() {

    private var buffer: ShortArray = ShortArray(BUFFER_SIZE/Short.SIZE_BYTES)

    override var inputStream: ShortArray = ShortArray(EqConstants.BUFFER_SIZE)

    override suspend fun createEffectAsync() = CoroutineScope(Dispatchers.IO).async {
        val savedSignal = buffer.clone()
        buffer = inputStream
        savedSignal
    }

    private companion object{
        const val ATTENUATION: Double = 0.7
        const val BUFFER_SIZE: Int = 3
    }

}