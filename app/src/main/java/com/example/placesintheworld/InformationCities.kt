package com.example.placesintheworld

import android.app.Activity
import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.palette.graphics.Palette
import com.example.placesintheworld.ui.theme.Claro
import com.example.placesintheworld.ui.theme.DarkBlue
import com.example.placesintheworld.ui.theme.Medio
import com.example.placesintheworld.ui.theme.Oscuro
import com.example.placesintheworld.ui.theme.saltyocean

@Composable
fun InformationCity(parameter: String, parameter1: Int) {

    val context = LocalContext.current
    val bitmap = remember { BitmapFactory.decodeResource(context.resources, R.drawable.image1) }
    val palette = remember { Palette.from(bitmap).generate() }
    val darkVibrantSwatch = palette.darkVibrantSwatch
    val lightVibrantSwatch = palette.lightVibrantSwatch

    val lightMutedSwatch = palette.lightMutedSwatch
    val mutedSwatch = palette.mutedSwatch
    val darkMutedSwatch = palette.darkMutedSwatch
    val view = LocalView.current
    val window = (view.context as Activity).window
    window.statusBarColor = palette.darkVibrantSwatch?.rgb ?: MaterialTheme.colorScheme.primary.toArgb()



    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()

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
                contentScale = ContentScale.Crop
            )
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(lightVibrantSwatch?.let { Color(it.rgb) } ?: Color.Green),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(text = "Light Vibrant")
        }

        Row(modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(darkVibrantSwatch?.let { Color(it.rgb) } ?: Color.Green),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(text = "Dark Vibrant")
        }

        Row(modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(lightMutedSwatch?.let { Color(it.rgb) } ?: Color.Green),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(text = "Light Muted")
        }

        Row(modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(mutedSwatch?.let { Color(it.rgb) } ?: Color.Green),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(text = "Muted")
        }

        Row(modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(darkMutedSwatch?.let { Color(it.rgb) } ?: Color.Green),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(text = "Dark Muted")
        }

    }
}