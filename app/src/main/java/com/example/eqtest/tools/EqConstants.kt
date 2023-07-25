package com.example.eqtest.tools

object EqConstants {

    const val BUFFER_SIZE = 16000
    const val FILTERS_COUNT = 6

    enum class RequestCodes(val id:Int){
        ExternalRequestCode(1),
        ApiLevelNotEnough(2),
    }

}