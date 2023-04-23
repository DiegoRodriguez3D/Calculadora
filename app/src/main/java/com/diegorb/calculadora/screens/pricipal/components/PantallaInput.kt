package com.diegorb.calculadora.screens.pricipal.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.diegorb.calculadora.screens.pricipal.CalculadoraState

@Composable
fun PantallaInput(state: CalculadoraState) {

    Text(
        //text = state.numero1 + (state.operacion ?: "") + state.numero2,
        text = "125 x 256",
        textAlign = TextAlign.End,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 1.dp, horizontal = 35.dp),
        fontWeight = FontWeight.Light,
        fontSize = 24.sp,
        color = Color.White,
        maxLines = 2
    )

    Text(
        //text = state.numero1 + (state.operacion ?: "") + state.numero2,
        text = "12312312",
        textAlign = TextAlign.End,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 1.dp, horizontal = 35.dp),
        fontWeight = FontWeight.Bold,
        fontSize = 42.sp,
        color = Color.White,
        maxLines = 2
    )

}