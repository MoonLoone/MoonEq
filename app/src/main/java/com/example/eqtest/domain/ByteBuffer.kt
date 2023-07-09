package com.example.eqtest.domain

import android.media.AudioTrack
import android.util.Log
import com.example.eqtest.tools.EqConstants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.InputStream

object ByteBuffer {

    suspend fun bufferLoop(inputStream: InputStream, track: AudioTrack) {
        var byteIndex = 0
        val music = ByteArray(EqConstants.BUFFER_SIZE)
        while (withContext(Dispatchers.IO) {
                inputStream.read(music)
            }.also { byteIndex = it } != -1) track.write(
            music,
            0,
            byteIndex
        )
    }

}