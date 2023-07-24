package com.example.eqtest.domain.equalizer.effects

import com.example.eqtest.tools.EqConstants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlin.random.Random
import kotlin.random.nextInt

class Chorus : Effect() {

    override var inputStream: ShortArray = ShortArray(EqConstants.BUFFER_SIZE / Short.SIZE_BYTES)
    private var delays: Array<Delay> = emptyArray()

    override suspend fun createEffectAsync() = CoroutineScope(Dispatchers.IO).async {
        val delaysResult = delays.map { it.createEffectAsync().await() }
        for (i in delays.indices) {
            for (j in inputStream.indices) {
                inputStream[j] = (inputStream[j] + delaysResult[i][j] / delays.size).toShort()
            }
        }
        delays = initDelays()
        inputStream
    }

    private fun initDelays(): Array<Delay> {
        val localDelays = Array(Random.nextInt(IntRange(2, 5))) {
            Delay(inputStream)
        }
        return localDelays
    }

}