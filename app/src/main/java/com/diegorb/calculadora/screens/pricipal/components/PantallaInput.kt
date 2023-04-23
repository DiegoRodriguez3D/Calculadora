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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.diegorb.calculadora.screens.pricipal.CalculadoraViewModel

@Composable
fun PantallaInput() {

    val viewModel = viewModel<CalculadoraViewModel>()
    val state = viewModel.state

    Text(
        text = state.numero1 + (state.operacion?.symbol ?: "") + state.numero2,
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
        text = state.numero1 + (state.operacion?.symbol ?: "") + state.numero2,
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