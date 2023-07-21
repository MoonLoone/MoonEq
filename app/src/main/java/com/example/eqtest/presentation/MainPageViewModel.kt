package com.example.eqtest.presentation

import android.content.Context
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eqtest.domain.ByteBuffer
import com.example.eqtest.domain.Player
import com.example.eqtest.domain.equalizer.Equalizer
import com.himanshoe.charty.common.ChartDataCollection
import com.himanshoe.charty.line.model.LineData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.Timer
import kotlin.concurrent.timerTask

class MainPageViewModel(context: Context) : ViewModel() {

    private val _chartDataCollection: MutableState<ChartDataCollection> = mutableStateOf(
        ChartDataCollection(listOf(LineData(yValue = 0f, xValue = 0)))
    )

    val chartDataCollection: State<ChartDataCollection> = _chartDataCollection

    private val player = Player(
        context = context
    )

    fun startMusic() {
        player.play()
        Timer(true).schedule(timerTask {
            CoroutineScope(viewModelScope.coroutineContext).launch {
                _chartDataCollection.value = ChartDataCollection(
                    ByteBuffer.equalizedMusic.slice(IntRange(0, 100)).toList()
                        .mapIndexed { index, item ->
                            LineData(xValue = index, yValue = item.toFloat())
                        })
            }
        }, 0, 50)
    }

    fun stopMusic() = player.stop()

    fun pauseMusic() = player.pause()

    fun setGain(gain: Double, sliderIndex: Int) = Equalizer.setFilterGain(gain, sliderIndex)


}