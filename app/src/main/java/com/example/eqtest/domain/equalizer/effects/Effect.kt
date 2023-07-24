package com.example.eqtest.domain.equalizer.effects

import kotlinx.coroutines.Deferred

abstract class Effect {

    abstract var inputStream: ShortArray

    abstract suspend fun createEffectAsync(): Deferred<ShortArray>

}