package com.example.eqtest.presentation

import android.content.Context
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eqtest.data.Song
import com.example.eqtest.domain.management.getAllWavSongsFromExternal

class DrawerViewModel : ViewModel() {

    val songsList = mutableListOf<Song>()

    fun getAllWavTrack(context: Context) = getAllWavSongsFromExternal(
        resolver = context.contentResolver,
        songsList = songsList
    )

}