package com.example.calisthenicsquest.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.calisthenicsquest.viewmodel.AuthState
import com.example.calisthenicsquest.viewmodel.AuthViewModel

@Composable
fun HomeScreen(modifier: Modifier = Modifier, navController: NavController, authViewModel: AuthViewModel) {
    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        val authState = authViewModel.authState.observeAsState()

        LaunchedEffect(authState.value) {
            when (authState.value) {
                is AuthState.UnAuthenticated -> navController.navigate("login")
                else -> Unit
            }
        }

        Text(
            text = "HOME PAGE",
            modifier = Modifier
                .clickable(
                    onClick = {
                        authViewModel.signOut()
                    }
                )
        )
    }
}