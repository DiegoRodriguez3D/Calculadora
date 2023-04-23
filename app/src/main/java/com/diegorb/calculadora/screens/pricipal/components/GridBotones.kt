package com.diegorb.calculadora.screens.pricipal.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.diegorb.calculadora.BotonCalculadora
import com.diegorb.calculadora.ui.theme.*

val rows = listOf(
    listOf(
        BotonTipo("C", ColorBoton.COLOR_ACCION),
        BotonTipo("+/-", ColorBoton.COLOR_ACCION),
        BotonTipo("%", ColorBoton.COLOR_ACCION),
        BotonTipo("/", ColorBoton.COLOR_OPERACION)
    ),
    listOf(
        BotonTipo("7", ColorBoton.COLOR_NUMEROS),
        BotonTipo("8", ColorBoton.COLOR_NUMEROS),
        BotonTipo("9", ColorBoton.COLOR_NUMEROS),
        BotonTipo("x", ColorBoton.COLOR_OPERACION)
    ),
    listOf(
        BotonTipo("4", ColorBoton.COLOR_NUMEROS),
        BotonTipo("5", ColorBoton.COLOR_NUMEROS),
        BotonTipo("6", ColorBoton.COLOR_NUMEROS),
        BotonTipo("-", ColorBoton.COLOR_OPERACION)
    ),
    listOf(
        BotonTipo("1", ColorBoton.COLOR_NUMEROS),
        BotonTipo("2", ColorBoton.COLOR_NUMEROS),
        BotonTipo("3", ColorBoton.COLOR_NUMEROS),
        BotonTipo("+", ColorBoton.COLOR_OPERACION)
    ),
    listOf(
        BotonTipo(color = ColorBoton.COLOR_ESPECIAL, icon = com.diegorb.calculadora.R.drawable.delete_icon),
        BotonTipo("0", ColorBoton.COLOR_NUMEROS),
        BotonTipo(".", ColorBoton.COLOR_NUMEROS),
        BotonTipo("=", ColorBoton.COLOR_OPERACION)
    )
)

data class BotonTipo(
    val text: String = "",
    val color: ColorBoton,
    val icon: Int? = null
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
    Row(modifier = Modifier
        .padding(5.dp)
        .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
        valor.map {tipoBoton ->
            BotonCalculadora(
                modifier = Modifier,
                symbol = tipoBoton.text,
                color = tipoBoton.getTextColor(),
                icon = tipoBoton.icon,
                roundness = 12
            ) {

            }
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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview(){
    CalculadoraTheme(darkTheme = true) {
        GridBotones()
    }
}