package com.example.eqtest.domain

import android.media.AudioTrack
import com.example.eqtest.tools.createAudioTrack
import com.example.eqtest.tools.startLoop
import java.io.InputStream


class Player(private val inputStream: InputStream) {

    private val track: AudioTrack = createAudioTrack()

    fun play() {
        ByteBuffer.isStop = false
        ByteBuffer.isPause = false
        startLoop(inputStream, track)
        track.play()
    }

    fun stop() {
        ByteBuffer.isStop = true
        track.stop()
    }

    fun pause() {
        ByteBuffer.isPause = true
        track.pause()
    }

}