package com.example.fakestore.presentation.navigation

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.fakestore.data.pref.TokenPref
import com.example.fakestore.presentation.ui.screenDetailsProduct.ScreenDetailsProduct
import com.example.fakestore.presentation.ui.screenHome.ScreenHome
import com.example.fakestore.presentation.ui.screenLogin.ScreenLogin
import com.example.fakestore.presentation.ui.screenRegister.ScreenRegister
import timber.log.Timber

const val HOME_TO_NAV_DETAILS_PRODUCT = "home_to_nav_details"

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val session = TokenPref.instanceValueFlow(LocalContext.current).collectAsState().value == null

    SharedTransitionLayout {
        NavHost(navController = navController, startDestination =
            if (session)Screen.LoginScreen.route else Screen.HomeScreen.route){

            composable(Screen.LoginScreen.route) {
                ScreenLogin(modifier = modifier, navController = navController)
            }
            composable(Screen.RegisterScreen.route) {
                ScreenRegister(modifier = modifier, navController = navController)
            }
            composable(Screen.HomeScreen.route) {
                ScreenHome(modifier = modifier, navController = navController, animationVisibilityScope = this)
            }

            composable(
                route = Screen.DetailsProductScreen.route,
                arguments = listOf(navArgument("productId") { type = NavType.IntType })
            ) { backStackEntry ->
                val productId = backStackEntry.arguments?.getInt("productId")
                ScreenDetailsProduct(
                    modifier = modifier
                        .fillMaxSize()
                        .sharedElement(
                            sharedContentState = rememberSharedContentState(
                                HOME_TO_NAV_DETAILS_PRODUCT + productId.toString()
                            ),
                            animatedVisibilityScope = this,
                            boundsTransform = { _, _ ->
                                tween(durationMillis = 500)
                            }
                        ),
                    id = productId ?: 0,
                    navController = navController
                )
            }



        }

    }

}