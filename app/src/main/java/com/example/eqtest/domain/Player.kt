package com.example.eqtest.domain

import android.content.Context
import android.media.AudioTrack
import android.net.Uri
import android.util.Log
import com.example.eqtest.R
import com.example.eqtest.tools.createAudioTrack
import com.example.eqtest.tools.startLoop
import java.io.InputStream


class Player(private val inputStream: InputStream) {

    private val track: AudioTrack = createAudioTrack()

    fun play() {
        startLoop(inputStream, track)
        track.play()
    }

    fun stop() {
        track.stop()
    }

    fun pause() {
        track.pause()
    }

}