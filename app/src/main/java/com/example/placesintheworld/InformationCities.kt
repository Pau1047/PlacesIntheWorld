package com.example.placesintheworld

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.placesintheworld.ui.theme.Claro
import com.example.placesintheworld.ui.theme.DarkBlue
import com.example.placesintheworld.ui.theme.Medio
import com.example.placesintheworld.ui.theme.Oscuro
import com.example.placesintheworld.ui.theme.saltyocean

@Composable
fun InformationCity(parameter: String, parameter1: Int) {
    val brush = Brush.verticalGradient(listOf(Oscuro, Medio, Claro))
    var selectionRotacion by remember { mutableStateOf(0f) }
    var selectionScale by remember { mutableStateOf(1f) }
    var selectionEfectoAlfa by remember { mutableStateOf(1f) }
    var selectionDesenfoque by remember { mutableStateOf(0f) }
    val rangeRotacion = 0f..360f
    val rangeScale = 0.5f..3f
    val rangeEfectoAlfa = 0f..1f
    val rangeDesenfoque = 0f..20f


    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(brush)
    ) {
        Text(
            text = parameter,
            fontSize = 65.sp,
            fontFamily = saltyocean,
            color= Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, bottom = 2.dp)
        )
        Row {
            Image(
                painter = painterResource(id = parameter1),
                contentDescription = "Photos",
                modifier = Modifier
                    .blur(radiusX = selectionDesenfoque.toInt().dp, radiusY = selectionDesenfoque.toInt().dp, edgeTreatment = BlurredEdgeTreatment.Unbounded)
                    .graphicsLayer {
                        this.rotationY = selectionRotacion
                        this.scaleX = selectionScale
                        this.scaleY = selectionScale
                        this.alpha = selectionEfectoAlfa
                    },
                contentScale = ContentScale.Crop
            )
        }
        Row {
            Slider(
                value = selectionRotacion,
                valueRange = rangeRotacion,
                onValueChange = { selectionRotacion = it },
                modifier = Modifier.width(180.dp),
                steps = 180,
                colors = SliderDefaults.colors(
                    thumbColor = Color.Yellow,
                    activeTrackColor = Color.Yellow,
                    inactiveTrackColor = Color.Blue,
                    activeTickColor = Color.Yellow,
                    inactiveTickColor = Color.Black,
                ),
            )
        }
        Row {
            Slider(
                value = selectionScale,
                valueRange = rangeScale,
                onValueChange = { selectionScale = it },
                modifier = Modifier.width(180.dp),
                steps = 100,
                colors = SliderDefaults.colors(
                    thumbColor = Color.Yellow,
                    activeTrackColor = Color.Yellow,
                    inactiveTrackColor = Color.Blue,
                    activeTickColor = Color.Yellow,
                    inactiveTickColor = Color.Black,
                ),
            )
        }
        Row {
            Slider(
                value = selectionEfectoAlfa,
                valueRange = rangeEfectoAlfa,
                onValueChange = { selectionEfectoAlfa = it },
                modifier = Modifier.width(180.dp),
                steps = 10,
                colors = SliderDefaults.colors(
                    thumbColor = Color.Yellow,
                    activeTrackColor = Color.Yellow,
                    inactiveTrackColor = Color.Blue,
                    activeTickColor = Color.Yellow,
                    inactiveTickColor = Color.Black,
                ),
            )
        }
        Row {
            Slider(
                value = selectionDesenfoque,
                valueRange = rangeDesenfoque,
                onValueChange = { selectionDesenfoque = it },
                modifier = Modifier.width(180.dp),
                steps = 20,
                colors = SliderDefaults.colors(
                    thumbColor = Color.Yellow,
                    activeTrackColor = Color.Yellow,
                    inactiveTrackColor = Color.Blue,
                    activeTickColor = Color.Yellow,
                    inactiveTickColor = Color.Black,
                ),
            )
        }
    }
}