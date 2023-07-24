package com.example.eqtest.domain.equalizer.effects

import com.example.eqtest.tools.EqConstants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlin.random.Random

class Chorus: Effect() {

    private val delays: Array<Delay>

    init {
        delays = initDelays()
    }

    override var inputStream: ShortArray = ShortArray(EqConstants.BUFFER_SIZE / Short.SIZE_BYTES)

    override suspend fun createEffectAsync() = CoroutineScope(Dispatchers.IO).async{
        for (i in delays.indices){
            for (j in inputStream.indices){
                inputStream[j] = (inputStream[j] + delays[i].createEffectAsync().await()[j] / delays.size).toShort()
            }
        }
        inputStream
    }

    private fun initDelays(): Array<Delay>{
        val randomDelaysCount = Random.nextInt()
        val localDelays = Array<Delay>(randomDelaysCount){
            Delay()
        }
        return localDelays
    }

}