package com.example.calisthenicsquest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.calisthenicsquest.ui.screen.AppNavGraph
import com.example.calisthenicsquest.ui.theme.CalisthenicsQuestTheme
import com.example.calisthenicsquest.viewmodel.AuthViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val authViewModel : AuthViewModel by viewModels()
        setContent {
            CalisthenicsQuestTheme {
                AppNavGraph(authViewModel = authViewModel)
            }
        }
    }
}

