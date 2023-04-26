package com.diegorb.calculadora

//Contiene las diferentes acciones que puede pulsar el usuario
sealed class Accion {
    data class Numero(val numero: Int) : Accion()
    object Borrar : Accion()
    object Limpiar : Accion()
    object Decimal : Accion()
    object Calcular : Accion()
    object CambiaSigno : Accion()
    object PorCiento : Accion()
    data class Operar(val operacion: Operacion) : Accion()
}