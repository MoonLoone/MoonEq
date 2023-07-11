package com.example.eqtest.tools

inline fun ByteArray.mapPairsToDoubles(block: (Byte, Byte) -> Double)
    = DoubleArray(size / 2){ i -> block(this[2 * i], this[2 * i + 1]) }

fun ByteArray.toDoubleSamples() = mapPairsToDoubles{ a, b ->
    (a.toInt() and 0xFF or (b.toInt() shl 8)).toDouble()
}
