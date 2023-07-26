package com.example.eqtest.tools

import android.media.AudioAttributes
import android.media.AudioFormat
import android.media.AudioTrack
import com.example.eqtest.domain.ByteBuffer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.InputStream

fun createAudioTrack(): AudioTrack {
    return AudioTrack.Builder()
        .setAudioFormat(
            AudioFormat.Builder().setEncoding(AudioFormat.ENCODING_PCM_16BIT)
                .setSampleRate(44100)
                .setChannelMask(AudioFormat.CHANNEL_OUT_STEREO)
                .build()
        )
        .setAudioAttributes(
            AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_GAME)
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .build()
        )
        .setBufferSizeInBytes(EqConstants.BUFFER_SIZE)
        .setTransferMode(AudioTrack.MODE_STREAM)
        .build()
}

fun startLoop(inputStreamFromRawFile: InputStream, track: AudioTrack) {
    CoroutineScope(Dispatchers.IO).launch {
        ByteBuffer.bufferLoop(inputStreamFromRawFile, track)
    }
}

