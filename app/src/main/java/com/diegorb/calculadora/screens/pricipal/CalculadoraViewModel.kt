package com.diegorb.calculadora.screens.pricipal

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.diegorb.calculadora.Accion
import com.diegorb.calculadora.Operacion

class CalculadoraViewModel : ViewModel() {

    var state by mutableStateOf(CalculadoraState())
        private set

    fun onAction(action: Accion) {
        when (action) {
            is Accion.Numero -> numero(action.numero)
            is Accion.Decimal -> decimal()
            is Accion.Limpiar -> state = CalculadoraState() //Reinicia el state
            is Accion.Operar -> opera(action.operacion)
            is Accion.Calcular -> calcula()
            is Accion.Borrar -> borra()
            is Accion.PositivoNegativo -> cambiaSigno()
        }
    }

    private fun cambiaSigno() {
        when {
            state.numero1.isNotBlank() -> state.copy(numero1 = "-" + state.numero1)
        }
    }

    private fun borra() {
        when {
            //Si el usuario introdujo segundo numero, borra el ultimo caracter del mismo
            state.numero2.isNotBlank() -> state.copy(numero2 = state.numero2.dropLast(1))
            //Si introdujo operacion, borra la operacion
            state.operacion != null -> state = state.copy(operacion = null)
            //Si introdujo primer numero, borra el ultimo caracter del mismo
            state.numero1.isNotBlank() -> state.copy(numero1 = state.numero1.dropLast(1))
        }
    }

    private fun calcula() {
        val numero1 = state.numero1.toDoubleOrNull()
        val numero2 = state.numero2.toDoubleOrNull()
        if(numero1 != null && numero2 != null){
            val resultado = when(state.operacion){
                is Operacion.Sumar -> numero1 + numero2
                is Operacion.Restar -> numero1 - numero2
                is Operacion.Multiplicar -> numero1 * numero2
                is Operacion.Dividir -> numero1 / numero2
                else -> {return}
            }
            state = state.copy(numero1 = resultado.toString().take(15), numero2 = "", operacion = null)
        }
    }

    private fun opera(operacion: Operacion) {
        if (state.numero1.isNotBlank()) {
            state = state.copy(operacion = operacion)
        }

    }

    private fun decimal() {
        if (state.operacion == null && !state.numero1.contains(".") && state.numero1.isNotBlank()) {
            state = state.copy(numero1 = state.numero1 + ".")
            return
        }

        if (!state.numero2.contains(".") && state.numero2.isNotBlank()) {
            state = state.copy(numero2 = state.numero2 + ".")
        }
    }

    private fun numero(numero: Int) {
        if(state.operacion == null){

            if(state.numero1.length >= MAX_NUM_LENGTH){
                return
            }
            state = state.copy(numero1 = state.numero1 + numero)
            return

        }

        if(state.numero2.length >= MAX_NUM_LENGTH){
            return
        }

        state = state.copy(numero2 = state.numero2 + numero)

    }

    companion object {
        private const val MAX_NUM_LENGTH = 8
    }

}