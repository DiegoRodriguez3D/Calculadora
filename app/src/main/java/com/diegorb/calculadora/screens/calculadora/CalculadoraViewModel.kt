package com.diegorb.calculadora.screens.calculadora

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculadoraViewModel: ViewModel(){

    var state by mutableStateOf(CalculadoraState())
        private set

}