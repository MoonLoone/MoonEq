package com.example.eqtest.domain

import android.media.AudioTrack
import android.util.Log
import com.example.eqtest.domain.equalizer.Equalizer
import com.example.eqtest.tools.byteArrayToShortArray
import com.example.eqtest.tools.EqConstants
import com.example.eqtest.tools.shortArrayToByteArray
import java.io.InputStream


object ByteBuffer {

    var equalizedMusic: ShortArray = ShortArray(EqConstants.BUFFER_SIZE / Short.SIZE_BYTES)
    var isPause: Boolean = false
    var isStop: Boolean = false

    suspend fun bufferLoop(inputStream: InputStream, track: AudioTrack) {
        try {
            val music = ByteArray(EqConstants.BUFFER_SIZE)
            while (inputStream.read(music) != -1) {
                if (isPause) break
                if (isStop) {
                    inputStream.close()
                    break
                }
                val musicInShortArray = byteArrayToShortArray(music)
                equalizedMusic = Equalizer.equalization(musicInShortArray)
                track.write(
                    shortArrayToByteArray(equalizedMusic),
                    0,
                    music.size
                )
            }
        } catch (e: Exception) {
            Log.d("!!!", "Stream unavailable ${e.localizedMessage}")
        }
    }
}