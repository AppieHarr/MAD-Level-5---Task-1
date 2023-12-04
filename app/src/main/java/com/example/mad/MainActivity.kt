package com.example.mad

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mad.ui.screens.CreateProfileScreen
import com.example.mad.ui.screens.ProfileScreen
import com.example.mad.ui.screens.Screens
import com.example.mad.ui.theme.MADTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ProfileApp()
        }
    }
}

@Composable
fun ProfileApp() {
    val navController = rememberNavController()
    Scaffold { innerPadding ->
        ProfileNavHost(navController, modifier = Modifier.padding(innerPadding))
    }
}

@Composable
fun ProfileNavHost(navController: NavHostController, modifier: Modifier = Modifier) {

    NavHost(
        navController = navController,
        startDestination = Screens.CreateProfileScreen.route,
        modifier = modifier
    ) {
        composable(route = Screens.CreateProfileScreen.route) {
            CreateProfileScreen(navController = navController, viewModel = viewModel())
        }
        composable(Screens.ProfileScreen.route) {
            ProfileScreen(viewModel = viewModel())
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MADTheme {

    }
}