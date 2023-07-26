package com.example.eqtest.domain.equalizer

interface Filter {

    var gain: Double

    fun convolution(input: ShortArray): ShortArray

}