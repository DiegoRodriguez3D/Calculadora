package com.diegorb.calculadora.screens.principal

import com.diegorb.calculadora.model.Operacion

//Contiene los numeros y la operacion que selecciona el usuario
data class CalculadoraState(
    val numero1: String = "",
    val operacion: Operacion? = null,
    val numero2: String = "",
    val resultado: String = "",

    //Almacenan los numeros y operador introducidos antes de mostrar el resultado
    val numero1OLD: String = "",
    val numero2OLD: String = "",
    val operacionOLD: Operacion? = null,
)
