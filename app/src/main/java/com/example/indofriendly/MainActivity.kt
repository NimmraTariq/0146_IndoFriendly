package com.example.indofriendly

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.indofriendly.ui.navigation.AppNavHost
import com.example.indofriendly.ui.theme.IndoFriendlyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IndoFriendlyTheme {
                Surface(modifier = Modifier.fillMaxSize().systemBarsPadding()) {
                    AppNavHost()
                }
            }
        }
    }
}