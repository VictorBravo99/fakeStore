package com.example.fakestore.presentation.navigation

sealed class Screen(val route:String) {
    data object LoginScreen : Screen("login_Screen")
    data object RegisterScreen : Screen("register_Screen")
    data object HomeScreen : Screen("home_Screen")
    data object DetailsProductScreen : Screen("details_product_screen/{productId}") {
        // Función helper para construir la ruta con el ID
        fun createRoute(productId: Int) = "details_product_screen/$productId"
    }
    data object SplashScreen : Screen("splash_Screen")
}