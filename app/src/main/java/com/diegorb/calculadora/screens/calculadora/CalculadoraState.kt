package com.diegorb.calculadora.screens.calculadora

import com.diegorb.calculadora.Operacion

//Contiene los numeros y la operacion que selecciona el usuario
data class CalculadoraState(
    val numero1: String = "",
    val numero2: String = "",
    val operacion: Operacion? = null,
)
