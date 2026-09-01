package com.swyp.pickple.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.swyp.pickple.navigation.AppNavHost


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen (){
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    val canNavigateBack = navBackStackEntry != null && navController.previousBackStackEntry != null

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                },
                navigationIcon = {
                    if (canNavigateBack) {
                        IconButton(onClick = { navController.navigateUp() }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "뒤로가기",
                            )
                        }
                    }
                }
            )
        }
    ){ paddingValues ->
        AppNavHost(paddingValues, navController)
    }
}