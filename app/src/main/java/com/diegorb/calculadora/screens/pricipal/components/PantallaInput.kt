package com.diegorb.calculadora.screens.pricipal.components

import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.viewmodel.compose.viewModel
import com.diegorb.calculadora.screens.pricipal.CalculadoraViewModel
import com.diegorb.calculadora.ui.theme.Rojo

@Composable
fun PantallaInput() {

    val viewModel = viewModel<CalculadoraViewModel>()
    val state = viewModel.state

    ConstraintLayout() {
        val (filaSuperior, filaInferior) = createRefs()

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 1.dp, horizontal = 35.dp)
                .constrainAs(filaSuperior) {
                    bottom.linkTo(filaInferior.top)
                    end.linkTo(parent.end)
                }, horizontalArrangement = Arrangement.End
        ) {
            Text(
                text = state.numero1OLD + " ",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = if(isSystemInDarkTheme())Color.LightGray else Color.Gray,
                maxLines = 1
            )
            Text(
                text = state.operacionOLD?.symbol ?: "",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Rojo,
                maxLines = 1,
            )
            Text(
                text = " " + state.numero2OLD,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = if(isSystemInDarkTheme())Color.LightGray else Color.Gray,
                maxLines = 2
            )
        }

        Text(
            text = if(state.numero1.isBlank()) "0" else state.numero1 + " " + (state.operacion?.symbol ?: "") + " " + state.numero2,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(vertical = 5.dp, horizontal = 5.dp)
                .border(4.dp, MaterialTheme.colorScheme.primary, RoundedCornerShape(12.dp))
                .padding(vertical = 15.dp)
                .constrainAs(filaInferior) {
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)
                },
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            color = MaterialTheme.colorScheme.tertiary,
            maxLines = 2,
            lineHeight = 32.sp,
            softWrap = true
        )
    }
}