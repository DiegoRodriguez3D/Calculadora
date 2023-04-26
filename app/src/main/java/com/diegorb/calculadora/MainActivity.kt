package com.diegorb.calculadora

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import com.diegorb.calculadora.screens.pricipal.CalculadoraScreen
import com.diegorb.calculadora.ui.theme.CalculadoraTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculadoraTheme {
                CalculadoraScreen()
            }
        }
    }
}