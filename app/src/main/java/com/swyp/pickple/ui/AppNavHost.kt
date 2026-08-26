package com.swyp.pickple.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.swyp.core.navigation.PageNavRoute.Home
import com.swyp.pickple.navigation.customNavGraphBuilder


@Composable
fun AppNavHost(
    paddingValues: PaddingValues,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Home,
        modifier = Modifier
            .padding(top = paddingValues.calculateTopPadding())
            .fillMaxSize()
    ) {
        customNavGraphBuilder(navController)
    }
}