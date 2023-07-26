package com.example.eqtest.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.eqtest.data.Song
import com.example.eqtest.domain.management.getAllWavSongsFromExternal

class DrawerViewModel : ViewModel() {

    val songsList = mutableListOf<Song>()

    fun getAllWavTrack(context: Context) = getAllWavSongsFromExternal(
        resolver = context.contentResolver,
        songsList = songsList
    )

}