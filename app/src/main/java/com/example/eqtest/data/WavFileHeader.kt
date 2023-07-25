package com.example.eqtest.data

import android.net.Uri

data class WavFileHeader(

    val uri: Uri? = Uri.EMPTY,

    val chunkID: String? = null, //"RIFF"

    var chunkSize: Int = 0, //The size of the rest of the chunk

    val format: String? = null, //"WAVE"

    val subChunk1ID: String? = null, //"fmt"

    val subChunk1Size: Int = 0, //16 for PCM(pulse code modulation)

    val audioFormat: Short = 0, //1

    val numChannels: Short = 0, //1 for mono, 2 for stereo

    val sampleRate: Int = 0,

    val byteRate: Int = 0, //Byte for second of audio
    // sampleRate*numChannels*bitsPerSample/8

    val blockAlign: Short = 0, //Bytes for one sample
    //numChannels*bitsPerSample/8

    val bitsPerSample: Short = 0, //8, 16, 24, 32

    val subChunk2ID: String? = null, //"data"

    var subChunk2Size: Int = 0, //numSamples*numChannels*bitsPerSample/8
)