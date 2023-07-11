package com.example.eqtest.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun MainPage(mainPageViewModel: MainPageViewModel = MainPageViewModel(LocalContext.current.applicationContext)) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.padding(top = 32.dp)
    ) {
        Button(onClick = { mainPageViewModel.startMusic() }) {
            Text(text = "Start")
        }
        Button(onClick = { mainPageViewModel.pauseMusic() }) {
            Text(text = "Pause")
        }
        Button(onClick = { mainPageViewModel.stopMusic() }) {
            Text(text = "Stop")
        }
    }
}
