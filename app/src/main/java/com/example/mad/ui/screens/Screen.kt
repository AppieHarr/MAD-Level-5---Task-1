package com.example.mad.ui.screens

sealed class Screens(val route: String) {
    object CreateProfileScreen: Screens("create_profile_screen")
    object ProfileScreen: Screens("profile_screen")
}
