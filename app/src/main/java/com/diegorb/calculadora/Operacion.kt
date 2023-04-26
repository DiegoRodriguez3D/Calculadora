package com.diegorb.calculadora

//Contiene los diferentes tipos de operacion que puede realizar el usuario
sealed class Operacion(val symbol: String) {
    object Sumar : Operacion("+")
    object Restar : Operacion("-")
    object Multiplicar : Operacion("×")
    object Dividir : Operacion("÷")
    object Porciento : Operacion("%")
}