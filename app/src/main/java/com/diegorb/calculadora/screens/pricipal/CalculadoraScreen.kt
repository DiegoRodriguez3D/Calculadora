package com.diegorb.calculadora.screens.pricipal

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.diegorb.calculadora.screens.pricipal.components.CalculadoraContent

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CalculadoraScreen() {
    val viewModel = viewModel<CalculadoraViewModel>()
    val state = viewModel.state
    Scaffold(topBar = {}, content = { CalculadoraContent(state) }, bottomBar = {})
}