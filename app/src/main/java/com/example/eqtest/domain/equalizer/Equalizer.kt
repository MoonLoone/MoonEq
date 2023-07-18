package com.example.eqtest.domain.equalizer

import com.example.listenmymusic.structure_elements.equalizer.coefs.FifthFir
import com.example.eqtest.domain.equalizer.coefs.FirstFir
import com.example.listenmymusic.structure_elements.equalizer.coefs.FourthFir
import com.example.eqtest.domain.equalizer.coefs.SecondFir
import com.example.eqtest.domain.equalizer.coefs.SixthFir
import com.example.eqtest.domain.equalizer.coefs.ThirdFir

object Equalizer {

    private val filters = listOf(
        Filter(
            FirstFir.firstFIR
        ),
        Filter(
            SecondFir.secondFIR
        ),
        Filter(
            ThirdFir.thirdFIR
        ),
        Filter(
            FourthFir.fourthFIR
        ),
        Filter(
            FifthFir.fifthFIR
        ),
        Filter(
            SixthFir.sixFIR
        ),
    )

    suspend fun equalization(input: Array<Double>) {
        val filterConvolution = Array(filters.size) {
            filters[it].convolutionAsync(input)
        }
        for (i in input.indices) {
            input[i] =
                input[i] + filterConvolution[0].await()[i] + filterConvolution[1].await()[i] + filterConvolution[2].await()[i] + +filterConvolution[3].await()[i] + filterConvolution[4].await()[i] + filterConvolution[5].await()[i]
        }
    }

    fun setFilterGain(gain: Double, index: Int) {
        filters[index].gain = gain
    }

}