package com.example.placesintheworld

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.placesintheworld.ui.theme.TranBlue

@Composable
fun CitiesView(navController: NavController) {
    Cities(navController)
}

@Composable
fun getCities():
    List<Data> {
        return listOf(
            Data("Morella", R.drawable.image),
            Data("Lugo", R.drawable.image1),
            Data("Bangkok", R.drawable.image2),
            Data("Perú", R.drawable.image3),
            Data("Pekín", R.drawable.image4),
            Data("Granada", R.drawable.image5),
            Data("Atenas", R.drawable.image6),
            Data("Yucatán", R.drawable.image7),
            Data("Seychelles", R.drawable.image8))
}

@Composable
fun CitiesItem(navController: NavController, DataItem: Data,onItemSelected: (Data) -> Unit) {
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(2.dp)
        .clickable {
            onItemSelected(DataItem)
            navController.navigate("InformationCity/${DataItem.name}/${DataItem.photo}") })
        {
        Image(
            painter = painterResource(id = DataItem.photo),
            contentDescription = "Photos",
            modifier = Modifier
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        ToolCard(DataItem)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToolCard(DataItem: Data) {
    TopAppBar(
        title = { Text(text = DataItem.name, color = Color.White, textDecoration = TextDecoration.Underline) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(TranBlue),
    )
}

@Composable
fun Cities(navController: NavController) {
    var selectedItem: Data? by remember { mutableStateOf(null) }
    val data = getCities()

    Column {
        LazyVerticalStaggeredGrid(columns = StaggeredGridCells.Fixed(2),
            content = {
                items(data.size) { city ->
                    CitiesItem(navController, DataItem = data[city]) {selectedItem = it}
                }
            })
        }
    }

