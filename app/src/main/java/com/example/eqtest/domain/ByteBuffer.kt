package com.example.eqtest.domain

import android.media.AudioTrack
import android.util.Log
import com.example.eqtest.domain.equalizer.Equalizer
import com.example.eqtest.tools.ByteArrayToShortArray
import com.example.eqtest.tools.EqConstants
import com.example.eqtest.tools.ShortArrayToByteArray
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.InputStream


object ByteBuffer {

    suspend fun bufferLoop(inputStream: InputStream, track: AudioTrack) {
        val music = ByteArray(EqConstants.BUFFER_SIZE)
        while (withContext(Dispatchers.IO) {
                inputStream.read(music)
            } != -1) {
            val msS = ByteArrayToShortArray(music)
            val equalizedMusic = Equalizer.equalization(msS)
            track.write(
                ShortArrayToByteArray(equalizedMusic),
                0,
                music.size
            )
        }
    }

}