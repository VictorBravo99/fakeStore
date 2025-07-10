package com.example.fakestore.presentation.navigation

sealed class Screen(val route:String) {
    data object LoginScreen : Screen("login_Screen")
    data object RegisterScreen : Screen("register_Screen")
    data object HomeScreen : Screen("home_Screen")
    data object SplashScreen : Screen("splash_Screen")
}