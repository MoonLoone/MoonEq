package com.example.eqtest.domain

import android.media.AudioTrack
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.eqtest.domain.equalizer.Equalizer
import com.example.eqtest.tools.ByteArrayToShortArray
import com.example.eqtest.tools.EqConstants
import com.example.eqtest.tools.ShortArrayToByteArray
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.InputStream


object ByteBuffer {

    var equalizedMusic: ShortArray = ShortArray(EqConstants.BUFFER_SIZE / Short.SIZE_BYTES)

    suspend fun bufferLoop(inputStream: InputStream, track: AudioTrack) {
        val music = ByteArray(EqConstants.BUFFER_SIZE)
        while (inputStream.read(music) != -1) {
            val musicInShortArray = ByteArrayToShortArray(music)
            equalizedMusic = Equalizer.equalization(musicInShortArray)
            track.write(
                ShortArrayToByteArray(equalizedMusic),
                0,
                music.size
            )
        }
    }
}