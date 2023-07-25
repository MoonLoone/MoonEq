package com.example.eqtest.domain.management

import android.content.ContentResolver
import android.os.Build
import android.provider.MediaStore
import androidx.core.net.toUri
import com.example.eqtest.data.Song
import com.example.eqtest.tools.EqConstants

fun getAllWavSongsFromExternal(resolver: ContentResolver, songsList: MutableList<Song>) {
        val songs = mutableSetOf<Song>()
        val musicUri = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            MediaStore.Audio.Media.getContentUri(MediaStore.VOLUME_EXTERNAL)
        } else MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
        val cursor = resolver.query(musicUri, null, null, null, null, null)
        if (cursor != null && cursor.moveToFirst()) {
            val musicTypeColumnId = cursor.getColumnIndex(MediaStore.Audio.Media.MIME_TYPE)
            val displayNameColumnId = cursor.getColumnIndex(MediaStore.Audio.Media.DISPLAY_NAME)
            val authorColumnId = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                cursor.getColumnIndex(MediaStore.Audio.Media.AUTHOR)
            } else {
                EqConstants.RequestCodes.ApiLevelNotEnough.id
            }
            val durationColumnId = cursor.getColumnIndex(MediaStore.Audio.Media.DURATION)
            val uri = cursor.getColumnIndex(MediaStore.Audio.Media.DATA)
            do {
                if (cursor.getString(musicTypeColumnId) == "audio/x-wav") {
                    songs.add(
                        Song(
                            cursor.getString(displayNameColumnId),
                            cursor.getString(authorColumnId) ?: "Nan",
                            cursor.getString(durationColumnId),
                            cursor.getString(uri).toUri(),
                        )
                    )
                }
            } while (cursor.moveToNext())
        }
        cursor?.close()
        songsList.addAll(songs)
    }

