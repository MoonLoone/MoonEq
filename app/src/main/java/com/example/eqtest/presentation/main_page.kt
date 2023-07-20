package com.example.eqtest.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.layout
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import com.example.eqtest.tools.EqConstants

@Preview
@Composable
fun MainPage(mainPageViewModel: MainPageViewModel = MainPageViewModel(LocalContext.current.applicationContext)) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 32.dp)
    ) {
        Row {
            for (i in 0 until EqConstants.FILTERS_COUNT)
                CustomSlider { gain: Double -> mainPageViewModel.setGain(gain, i) }
        }
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

@Composable
fun CustomSlider(setGain: (Double) -> Unit) {
    var sliderPosition by remember { mutableStateOf(0f) }
    Slider(
        modifier = Modifier
            .graphicsLayer {
                rotationZ = 270f
                transformOrigin = TransformOrigin(0f, 0f)
            }
            .layout { measurable, constraints ->
                val placeable = measurable.measure(
                    Constraints(
                        minWidth = constraints.minHeight,
                        maxWidth = constraints.maxHeight,
                        minHeight = constraints.minWidth,
                        maxHeight = constraints.maxHeight,
                    )
                )
                layout(placeable.height, placeable.width) {
                    placeable.place(-placeable.width, 0)
                }
            }
            .width(120.dp)
            .height(50.dp),
        value = sliderPosition,
        valueRange = 0f..1f,
        onValueChange = {
            sliderPosition = it
            setGain(sliderPosition.toDouble())
        }
    )
}
