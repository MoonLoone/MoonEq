package com.example.eqtest.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.eqtest.domain.Player

class MainPageViewModel(context: Context) : ViewModel() {

    private val player = Player(
        context = context
    )

    fun startMusic() = player.play()

    fun stopMusic() = player.stop()

    fun pauseMusic() = player.pause()

}