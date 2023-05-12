package com.diegorb.calculadora.screens.principal

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.diegorb.calculadora.model.Accion
import com.diegorb.calculadora.model.Operacion

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
            is Accion.CambiaSigno -> cambiaSigno()
            is Accion.PorCiento -> porCiento()
        }
    }

    private fun cambiaSigno() {
        if (state.numero1.isNotBlank() && state.numero2.isBlank()) {
            state = state.copy(
                numero1 = if (state.numero1.contains("-")) state.numero1.replace(
                    "-", ""
                ) else "-" + state.numero1
            )
        } else if (state.operacion != null && state.numero2.isNotBlank()) {
            state = state.copy(
                numero2 = if (state.numero2.contains("-")) state.numero2.replace(
                    "-", ""
                ) else "-" + state.numero2
            )
        }
    }

    private fun borra() {
        if (state.operacion == null) {
            state = state.copy(numero1 = state.numero1.dropLast(1))
        } else if (state.numero2.isBlank()) {
            state = state.copy(operacion = null)
        } else {
            state = state.copy(numero2 = state.numero2.dropLast(1))
        }
    }

    private fun calcula() {
        val numero1 = state.numero1.toDoubleOrNull()
        val numero2 = state.numero2.toDoubleOrNull()
        val operador = state.operacion
        if (numero1 != null && numero2 != null) {
            val resultado = when (state.operacion) {
                is Operacion.Sumar -> numero1 + numero2
                is Operacion.Restar -> numero1 - numero2
                is Operacion.Multiplicar -> numero1 * numero2
                is Operacion.Dividir -> numero1 / numero2
                else -> {
                    return
                }
            }
            state = state.copy(
                resultado = resultado.toString().take(15),
                numero1OLD = numero1.toString(),
                numero2OLD = numero2.toString(),
                numero1 = resultado.toString(),
                numero2 = "",
                operacionOLD = operador,
                operacion = null
            )
        } else {
            val resultado = when (state.operacion) {
                is Operacion.Porciento -> numero1?.div(100)
                else -> {
                    return
                }
            }
            state = state.copy(
                resultado = resultado.toString().take(15),
                numero1OLD = numero1.toString(),
                numero2OLD = numero2.toString(),
                numero1 = resultado.toString(),
                numero2 = "",
                operacionOLD = operador,
                operacion = null
            )
        }
    }

    private fun porCiento() {
        if (state.numero2.isBlank()) {
            val numero1 = state.numero1.toDoubleOrNull()
            val resultado1 = numero1?.div(100)
            state = state.copy(numero1 = resultado1.toString())
        } else {
            val numero2 = state.numero2.toDoubleOrNull()
            val resultado2 = numero2?.div(100)
            state = state.copy(numero2 = resultado2.toString())
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
        if (state.operacion == null) {
            if (state.numero1.length >= MAX_NUM_LENGTH) {
                return
            }
            state = state.copy(numero1 = state.numero1 + numero)
            return
        }
        if (state.numero2.length >= MAX_NUM_LENGTH) {
            return
        }
        state = state.copy(numero2 = state.numero2 + numero)
    }

    companion object {
        private const val MAX_NUM_LENGTH = 8
    }
}