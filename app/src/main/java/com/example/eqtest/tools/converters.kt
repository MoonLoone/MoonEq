package com.example.eqtest.tools

import java.nio.ByteBuffer
import java.nio.ByteOrder

fun byteArrayToShortArray(bufferBytes: ByteArray): ShortArray {
    var i = 0
    var j = 0
    val bufferShort = ShortArray(bufferBytes.size / 2)
    while (i < bufferBytes.size) {
        bufferShort[j] = (ByteBuffer.wrap(bufferBytes, i, 2)
            .order(ByteOrder.LITTLE_ENDIAN)
            .short / 2).toShort()
        i += 2
        j++
    }
    return bufferShort
}

fun shortArrayToByteArray(bufferShort: ShortArray): ByteArray {
    var i = 0
    var j = 0
    val bufferBytes = ByteArray(bufferShort.size * 2)
    while (i < bufferShort.size && j < bufferBytes.size) {
        bufferBytes[j] = bufferShort[i].toByte()
        bufferBytes[j + 1] = (bufferShort[i].toInt() ushr 8).toByte()
        i++
        j += 2
    }
    return bufferBytes
}

fun byteArrayToNumber(
    bytes: ByteArray, numOfBytes: Int, type: Int,
): ByteBuffer {
    val buffer = ByteBuffer.allocate(numOfBytes)
    if (type == 0) {
        buffer.order(ByteOrder.BIG_ENDIAN)
    } else {
        buffer.order(ByteOrder.LITTLE_ENDIAN)
    }
    buffer.put(bytes)
    buffer.rewind()
    return buffer
}

