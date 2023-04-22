package com.diegorb.calculadora

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.unit.dp
import com.diegorb.calculadora.screens.calculadora.CalculadoraScreen
import com.diegorb.calculadora.ui.theme.CalculadoraTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculadoraTheme {

                val espacioGrid = 10.dp

                CalculadoraScreen()

            }
        }
    }
}