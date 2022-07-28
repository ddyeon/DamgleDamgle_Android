package com.mashup.damgledamgle.presentation.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash_screen")
    object Onboarding: Screen("onboarding_screen")
    object Home : Screen("home_screen")
    object Mypage : Screen("mypage_screen")
}
