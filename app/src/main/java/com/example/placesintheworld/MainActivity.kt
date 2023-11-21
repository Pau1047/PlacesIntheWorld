package com.example.placesintheworld

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.placesintheworld.ui.theme.Blue80
import com.example.placesintheworld.ui.theme.DarkBlue
import com.example.placesintheworld.ui.theme.PlacesIntheWorldTheme

class  MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "SuspiciousIndentation")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlacesIntheWorldTheme {
                val navController = rememberNavController()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { MyTopAppBar() },
                    floatingActionButton = {
                        FloatingActionButton(
                            onClick = { navController.navigate("Cities") },
                            containerColor = Blue80,
                            elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
                        ) { Icon(Icons.Filled.ArrowBack, "Next") }
                    },
                    floatingActionButtonPosition = FabPosition.End
                )
                {
                    Box(
                        modifier = Modifier.fillMaxSize()
                            .padding(top = it.calculateTopPadding())
                    ) {

                        NavHost(navController = navController, startDestination = "Cities"
                        ) {
                            composable("Cities") { CitiesView(navController = navController) }
                            composable("InformationCity/{nomfoto}/{foto}",
                                arguments = listOf(
                                    navArgument("nomfoto") { type = NavType.StringType } ,
                                    navArgument("foto") { type = NavType.IntType }
                                )
                            ) { backStackEntry ->
                                val nombrefoto = backStackEntry.arguments?.getString("nomfoto") ?: ""
                                val foto = backStackEntry.arguments?.getInt("foto") ?: ""
                                InformationCity(nombrefoto, foto as Int)
                            }
                        }
                    }
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun MyTopAppBar() {
        TopAppBar(
            title = { Text(text = "PlacesIntheWorld", color = Color.White) },
            colors = TopAppBarDefaults.mediumTopAppBarColors(DarkBlue),
            navigationIcon = {
                IconButton(onClick = { }) {
                    Icon(imageVector = Icons.Filled.Menu, tint = Color.White, contentDescription = "Menu")
                }
            },
            actions = {
                Icon(
                    imageVector = Icons.Filled.MoreVert,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.padding(end = 5.dp)
                )
            },
        )
    }
}