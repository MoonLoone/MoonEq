package com.example.eqtest.domain

import android.content.Context
import android.media.AudioTrack
import com.example.eqtest.R
import com.example.eqtest.tools.createAudioTrack
import com.example.eqtest.tools.startLoop
import kotlinx.coroutines.Job


class Player(context: Context) {

    private val track: AudioTrack = createAudioTrack()
    private val inputStreamFromRawFile = context.resources.openRawResource(R.raw.sound)

    fun play() {
        track.play()
        startLoop(inputStreamFromRawFile, track)
    }

    fun stop(){
        track.stop()
    }

    fun pause(){
        track.pause()
    }

}