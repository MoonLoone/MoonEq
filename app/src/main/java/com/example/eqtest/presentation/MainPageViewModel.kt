package com.example.eqtest.presentation

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.eqtest.domain.Player
import com.example.eqtest.domain.equalizer.Equalizer

class MainPageViewModel(context: Context) : ViewModel() {

    private val player = Player(
        context = context
    )

    fun startMusic() = player.play()

    fun stopMusic() = player.stop()

    fun pauseMusic() = player.pause()

    fun setGain(gain: Double, sliderIndex: Int) = Equalizer.setFilterGain(gain, sliderIndex)


}