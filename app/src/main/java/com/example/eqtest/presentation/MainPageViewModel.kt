package com.example.eqtest.presentation

import android.content.Context
import android.util.Log
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.yml.charts.axis.AxisData
import co.yml.charts.common.model.Point
import com.example.eqtest.domain.ByteBuffer
import com.example.eqtest.domain.Player
import com.example.eqtest.domain.equalizer.Equalizer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.Timer
import kotlin.concurrent.timerTask
import kotlin.math.absoluteValue

class MainPageViewModel(context: Context) : ViewModel() {

    private val _pointsStateData: MutableStateFlow<List<Point>> =
        MutableStateFlow(
            ByteBuffer.equalizedMusic.slice(IntRange(20, 50))
                .mapIndexed { item, index -> Point(index.toFloat(), item.toFloat()) })
    val pointsStateData: StateFlow<List<Point>> = _pointsStateData

    private val player = Player(
        context = context
    )

    val xAxisData = AxisData.Builder()
        .startPadding(20.dp)
        .steps(50)
        .labelData { i -> i.toString() }
        .labelAndAxisLinePadding(15.dp)
        .labelData { i ->
            i.toString()
        }
        .build()

    val yAxisData = AxisData.Builder()
        .steps(500)
        .backgroundColor(Color.Red)
        .labelAndAxisLinePadding(20.dp)
        .build()

    fun startMusic() {
        player.play()
        Timer(true).schedule(timerTask {
            CoroutineScope(viewModelScope.coroutineContext).launch {
                _pointsStateData.value = ByteBuffer.equalizedMusic.slice(IntRange(20, 50))
                    .mapIndexed { index, item -> Point(index.toFloat(), item.toFloat()) }
            }
        }, 1000, 5000)
    }

    fun stopMusic() = player.stop()

    fun pauseMusic() = player.pause()

    fun setGain(gain: Double, sliderIndex: Int) = Equalizer.setFilterGain(gain, sliderIndex)


}