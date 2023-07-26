package com.example.eqtest.presentation

import android.graphics.BitmapFactory
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.layout.layout
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import com.example.eqtest.data.Song
import com.example.eqtest.domain.equalizer.Equalizer
import com.example.eqtest.tools.EqConstants
import com.himanshoe.charty.common.config.AxisConfig
import com.himanshoe.charty.line.LineChart
import com.himanshoe.charty.line.config.LineConfig
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext

@Composable
fun MainPage(mainPageViewModel: MainPageViewModel = MainPageViewModel()) {
    var checkDistortion by remember {
        mutableStateOf(false)
    }
    var checkChorus by remember {
        mutableStateOf(false)
    }
    Drawer(
        setSong = {
            mainPageViewModel.createInputStream(
                musicUri = it,
            )
        }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 32.dp)
        ) {
            Box(
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp)
                    .height(300.dp)
                    .fillMaxWidth()
            ) {
                val points by remember {
                    mainPageViewModel.chartDataCollection
                }
                LineChart(
                    dataCollection = points,
                    axisConfig = AxisConfig(
                        showAxes = true,
                        showGridLines = true,
                        showGridLabel = true,
                        axisColor = Color.Black,
                        axisStroke = 0f,
                        minLabelCount = 0
                    ),
                    lineConfig = LineConfig(
                        hasDotMarker = false,
                        strokeSize = 5f,
                        hasSmoothCurve = false
                    )
                )
            }
            Row(verticalAlignment = Alignment.Bottom) {
                Text(text = "Gain")
                for (i in 0 until EqConstants.FILTERS_COUNT)
                    CustomSlider { gain: Double -> mainPageViewModel.setGain(gain, i) }
            }
            Buttons(
                startMusic = { mainPageViewModel.startMusic() },
                pauseMusic = { mainPageViewModel.pauseMusic() },
                stopMusic = { mainPageViewModel.stopMusic() })
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = "Distortion")
                    Checkbox(
                        checked = checkDistortion,
                        onCheckedChange = {
                            checkDistortion = !checkDistortion
                            Equalizer.isDistortion = checkDistortion
                        })
                }
                Column {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(text = "Chorus")
                        Checkbox(
                            checked = checkChorus,
                            onCheckedChange = {
                                checkChorus = !checkChorus
                                Equalizer.isChorus = checkChorus
                            })
                    }
                }
            }
        }
    }
}

@Composable
fun CustomSlider(setGain: (Double) -> Unit) {
    var sliderPosition by remember { mutableStateOf(1f) }
    Column {
        Slider(
            steps = 10,
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
            valueRange = 0f..5f,
            onValueChange = {
                sliderPosition = it
                setGain(sliderPosition.toDouble())
            }
        )
        Text(
            text = sliderPosition.toString()
                .slice(IntRange(0, minOf(sliderPosition.toString().length - 1, 5))),
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

@Composable
fun Drawer(setSong: (musicUri: Uri) -> Unit, content: @Composable () -> Unit) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val drawerViewModel = DrawerViewModel()
    val coroutineContext = rememberCoroutineScope()
    ModalNavigationDrawer(drawerContent = {
        drawerViewModel.getAllWavTrack(LocalContext.current)
        val songs = drawerViewModel.songsList.toList()
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp, top = 64.dp)
        ) {
            items(songs.size) { index ->
                SongItem(song = songs[index], onClick = {
                    coroutineContext.launch { drawerState.close() }
                    setSong(it)
                })
            }
        }
    }, drawerState = drawerState, content = content)
}

@Composable
fun Buttons(startMusic: () -> Unit, pauseMusic: () -> Unit, stopMusic: () -> Unit) {
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        Button(onClick = startMusic) {
            Text(text = "Start")
        }
        Button(onClick = pauseMusic) {
            Text(text = "Pause")
        }
        Button(onClick = stopMusic) {
            Text(text = "Stop")
        }
    }
}

@Composable
fun SongItem(song: Song, onClick: (musicUri: Uri) -> Unit) {
    Column(
        modifier = Modifier
            .background(color = Color.Cyan, shape = RoundedCornerShape(8.dp))
            .padding(8.dp)
            .clickable { onClick(song.uri) },
    ) {
        Text(text = song.displayName.slice(IntRange(0, minOf(song.displayName.length - 1, 20))))
        Text(text = "Author: ${song.author}")
        Text(text = "Duration in seconds: ${song.duration}")
    }
}

