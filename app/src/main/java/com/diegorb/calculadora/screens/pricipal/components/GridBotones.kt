package com.diegorb.calculadora.screens.pricipal.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.diegorb.calculadora.Accion
import com.diegorb.calculadora.BotonCalculadora
import com.diegorb.calculadora.Operacion
import com.diegorb.calculadora.screens.pricipal.CalculadoraViewModel
import com.diegorb.calculadora.ui.theme.*



val rows = listOf(
    listOf(
        BotonTipo("AC", ColorBoton.COLOR_ACCION, action = Accion.Limpiar),
        BotonTipo("+/-", ColorBoton.COLOR_ACCION, action = Accion.PositivoNegativo),
        BotonTipo("%", ColorBoton.COLOR_ACCION, action = Accion.Operar(Operacion.Porciento)),
        BotonTipo("/", ColorBoton.COLOR_OPERACION, action = Accion.Operar(Operacion.Dividir))
    ),
    listOf(
        BotonTipo("7", ColorBoton.COLOR_NUMEROS, action = Accion.Numero(7)),
        BotonTipo("8", ColorBoton.COLOR_NUMEROS, action = Accion.Numero(8)),
        BotonTipo("9", ColorBoton.COLOR_NUMEROS, action = Accion.Numero(9)),
        BotonTipo("x", ColorBoton.COLOR_OPERACION, action = Accion.Operar(Operacion.Multiplicar))
    ),
    listOf(
        BotonTipo("4", ColorBoton.COLOR_NUMEROS, action = Accion.Numero(4)),
        BotonTipo("5", ColorBoton.COLOR_NUMEROS, action = Accion.Numero(5)),
        BotonTipo("6", ColorBoton.COLOR_NUMEROS, action = Accion.Numero(6)),
        BotonTipo("-", ColorBoton.COLOR_OPERACION, action = Accion.Operar(Operacion.Restar))
    ),
    listOf(
        BotonTipo("1", ColorBoton.COLOR_NUMEROS, action = Accion.Numero(1)),
        BotonTipo("2", ColorBoton.COLOR_NUMEROS, action = Accion.Numero(2)),
        BotonTipo("3", ColorBoton.COLOR_NUMEROS, action = Accion.Numero(3)),
        BotonTipo("+", ColorBoton.COLOR_OPERACION, action = Accion.Operar(Operacion.Sumar))
    ),
    listOf(
        BotonTipo(color = ColorBoton.COLOR_ESPECIAL, icon = com.diegorb.calculadora.R.drawable.delete_icon, action = Accion.Borrar),
        BotonTipo("0", ColorBoton.COLOR_NUMEROS, action = Accion.Numero(0)),
        BotonTipo(".", ColorBoton.COLOR_NUMEROS, action = Accion.Decimal),
        BotonTipo("=", ColorBoton.COLOR_OPERACION, action = Accion.Calcular)
    )
)

data class BotonTipo(
    val text: String = "",
    val color: ColorBoton,
    val icon: Int? = null,
    val action: Accion
)

enum class ColorBoton {
    COLOR_NUMEROS,
    COLOR_OPERACION,
    COLOR_ACCION,
    COLOR_ESPECIAL
}

@Composable
fun GridBotones() {
    Column(modifier = Modifier
        .padding(vertical = 30.dp, horizontal = 15.dp)
        .fillMaxWidth()) {
        rows.map {tipoBoton ->
            RowCalculadora(tipoBoton)
        }
    }
}

@Composable
fun RowCalculadora(valor: List<BotonTipo>){
    val viewModel = viewModel<CalculadoraViewModel>()
    Row(modifier = Modifier
        .padding(5.dp)
        .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
        valor.map {tipoBoton ->
            BotonCalculadora(
                modifier = Modifier,
                symbol = tipoBoton.text,
                color = tipoBoton.getTextColor(),
                icon = tipoBoton.icon,
                roundness = 12,
                onClick = {viewModel.onAction(tipoBoton.action)}
            )
        }
    }
}

private fun BotonTipo.getTextColor(): Color {
    return when(color){
        ColorBoton.COLOR_NUMEROS -> {Blanco}
        ColorBoton.COLOR_ACCION -> {Verde}
        ColorBoton.COLOR_OPERACION -> {Rojo}
        ColorBoton.COLOR_ESPECIAL ->{Naranja}

    }
}