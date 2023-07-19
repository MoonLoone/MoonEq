package com.example.eqtest.tools

import java.nio.ByteBuffer


fun toShortArray(byteArray: ByteArray): ShortArray {
    val shortArray = ShortArray(byteArray.size/Short.SIZE_BYTES)
    for (i in shortArray.indices) {
        shortArray[i] = ((byteArray[2 * i].toInt() shl 8) + byteArray[2 * i + 1].toInt()).toShort()
    }
    return shortArray
}

fun shortArrayToByteArray(input: ShortArray): ByteArray {
    val buffer = ByteBuffer.allocate(input.size*2)
    for (i  in input ){
        buffer.putShort(i)
    }
    return buffer.array()
}
