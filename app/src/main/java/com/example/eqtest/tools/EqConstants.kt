package com.example.eqtest.tools

object EqConstants {

    const val BUFFER_SIZE = 80000
    const val FILTERS_COUNT = 6
    const val MAX_GRAPH = 3000

    enum class RequestCodes(val id:Int){
        ExternalRequestCode(1),
        ApiLevelNotEnough(2),
    }

}