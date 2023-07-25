package com.example.eqtest.presentation

import android.media.MediaRecorder.AudioSource
import android.net.Uri
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eqtest.domain.ByteBuffer
import com.example.eqtest.domain.Player
import com.example.eqtest.domain.equalizer.Equalizer
import com.example.eqtest.tools.EqConstants
import com.example.eqtest.tools.createWavFileHeader
import com.himanshoe.charty.common.ChartDataCollection
import com.himanshoe.charty.line.model.LineData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.io.File
import java.io.FileInputStream
import java.io.InputStream
import java.util.Timer
import kotlin.concurrent.timerTask


class MainPageViewModel() : ViewModel() {

    private var inputStream: InputStream? = null

    private val _chartDataCollection: MutableState<ChartDataCollection> = mutableStateOf(
        ChartDataCollection(listOf(LineData(yValue = 0f, xValue = 0)))
    )

    val chartDataCollection: State<ChartDataCollection> = _chartDataCollection

    private var player: Player? = null

    fun startMusic() {
        inputStream?.let {
            player = Player(
                inputStream!!,
            )
            player!!.play()
            CoroutineScope(viewModelScope.coroutineContext).launch {
                Timer(true).schedule(timerTask {
                    _chartDataCollection.value = ChartDataCollection(
                        ByteBuffer.equalizedMusic.slice(
                            IntRange(
                                0,
                                minOf(EqConstants.BUFFER_SIZE / 4, EqConstants.MAX_GRAPH)
                            )
                        )
                            .toList()
                            .mapIndexed { index, item ->
                                LineData(
                                    xValue = index,
                                    yValue = item.toFloat()
                                )
                            })
                }, 0, 100)
            }
        }
    }

    fun stopMusic() = player?.stop()

    fun pauseMusic() = player?.pause()

    fun setGain(gain: Double, sliderIndex: Int) = Equalizer.setFilterGain(gain, sliderIndex)

    fun createInputStream(musicUri: Uri) {
        val file = musicUri.path?.let { File(it) }
        Log.d("!!!", createWavFileHeader(musicUri).toString())
        inputStream = FileInputStream(file)
    }

}