package com.example.eqtest.domain

import android.media.AudioTrack
import android.util.Log
import com.example.eqtest.domain.equalizer.Equalizer
import com.example.eqtest.tools.EqConstants
import com.example.eqtest.tools.shortArrayToByteArray
import com.example.eqtest.tools.toShortArray
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.InputStream


object ByteBuffer {

    suspend fun bufferLoop(inputStream: InputStream, track: AudioTrack) {
        val music = ByteArray(EqConstants.BUFFER_SIZE)
        while (withContext(Dispatchers.IO) {
                inputStream.read(music)
            } != -1) {
            Log.d("!!!", "Before "+music.toList().toString())
            val musicInShort = toShortArray(music)
                Equalizer.equalization(musicInShort)
                Log.d("!!!", "After "+musicInShort.toList().toString())
                track.write(
                    shortArrayToByteArray(musicInShort),
                    0,
                    music.size
                )
            }
    }

}