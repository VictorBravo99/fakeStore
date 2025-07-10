package com.example.fakestore.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fakestore.data.pref.TokenPref
import com.example.fakestore.presentation.ui.screenHome.ScreenHome
import com.example.fakestore.presentation.ui.screenLogin.ScreenLogin
import com.example.fakestore.presentation.ui.screenRegister.ScreenRegister

@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val session = TokenPref.instanceValueFlow(LocalContext.current).collectAsState().value == null

    NavHost(navController = navController, startDestination =
        if (session)Screen.LoginScreen.route else Screen.HomeScreen.route){

        composable(Screen.LoginScreen.route) {
            ScreenLogin(modifier = modifier, navController = navController)
        }
        composable(Screen.RegisterScreen.route) {
            ScreenRegister(modifier = modifier, navController = navController)
        }
        composable(Screen.HomeScreen.route) {
            ScreenHome(modifier = modifier, navController = navController)

        }

    }
}