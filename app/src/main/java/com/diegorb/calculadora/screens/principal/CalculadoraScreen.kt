package com.diegorb.calculadora.screens.principal

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.diegorb.calculadora.screens.principal.components.CalculadoraContent

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CalculadoraScreen() {
    Scaffold(topBar = {}, content = { CalculadoraContent() }, bottomBar = {})
}