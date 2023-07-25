package com.example.eqtest.tools

import android.net.Uri
import android.util.Log
import com.example.eqtest.data.WavFileHeader
import java.io.File
import java.io.FileInputStream
import java.io.IOException

fun createWavFileHeader(musicUri: Uri): WavFileHeader {
    val file = try {
        val musicFile = musicUri.path?.let { File(it) }
        val inputStream = FileInputStream(musicFile)
        val bytes = ByteArray(4)
        inputStream.read(bytes, 0, 4)
        val chunkID = String(bytes)
        inputStream.read(bytes, 0, 4)
        val chunkSize: Int = byteArrayToNumber(bytes, 4, 1).int
        inputStream.read(bytes, 0, 4)
        val format = String(bytes)
        inputStream.read(bytes, 0, 4)
        val subChunk1ID = String(bytes)
        inputStream.read(bytes, 0, 4)
        val subChunk1Size: Int = byteArrayToNumber(bytes, 4, 1).int
        inputStream.read(bytes, 0, 2)
        val audioFormat: Short =
            byteArrayToNumber(bytes.copyOf(2), 2, 1).short
        inputStream.read(bytes, 0, 2)
        val numChannels: Short =
            byteArrayToNumber(bytes.copyOf(2), 2, 1).short
        inputStream.read(bytes, 0, 4)
        val sampleRate: Int = byteArrayToNumber(bytes, 4, 1).int
        inputStream.read(bytes, 0, 4)
        val byteRate: Int = byteArrayToNumber(bytes, 4, 1).int
        inputStream.read(bytes, 0, 2)
        val blockAlign: Short =
            byteArrayToNumber(bytes.copyOf(2), 2, 1).short
        inputStream.read(bytes, 0, 2)
        val bitsPerSample: Short =
            byteArrayToNumber(bytes.copyOf(2), 2, 1).short
        inputStream.read(bytes, 0, 4)
        val subChunk2ID = String(bytes)
        inputStream.read(bytes, 0, 4)
        val subChunk2Size: Int = byteArrayToNumber(bytes, 4, 1).int
        WavFileHeader(
            musicUri,
            chunkID,
            chunkSize,
            format,
            subChunk1ID,
            subChunk1Size,
            audioFormat,
            numChannels,
            sampleRate,
            byteRate,
            blockAlign,
            bitsPerSample,
            subChunk2ID,
            subChunk2Size,
        )

    } catch (e: IOException) {
        Log.d("!!!", e.message.toString())
        WavFileHeader()
    }
    return file
}
