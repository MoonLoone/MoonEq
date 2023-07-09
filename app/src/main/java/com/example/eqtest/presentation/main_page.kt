package com.example.eqtest.presentation

import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainPage(mainPageViewModel: MainPageViewModel = MainPageViewModel(LocalContext.current.applicationContext)) {
    Scaffold() {
        val padding = it
        Button(onClick = { mainPageViewModel.startMusic() }) {
            Text(text = "Start")
        }
    }
}
