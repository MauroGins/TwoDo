package com.example.twodo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.twodo.ui.page.PaginaInicio
import com.example.twodo.ui.theme.TwoDoTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TwoDoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PaginaInicio(

                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


