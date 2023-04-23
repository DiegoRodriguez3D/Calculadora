package com.diegorb.calculadora.screens.pricipal.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.diegorb.calculadora.Accion
import com.diegorb.calculadora.screens.pricipal.CalculadoraState
import com.diegorb.calculadora.ui.theme.FondoCardOscuro

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun CalculadoraContent(
    state: CalculadoraState,
    modifier: Modifier = Modifier,
) {

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (botones) = createRefs()
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(botones) {
                    bottom.linkTo(parent.bottom)
                }, verticalArrangement = Arrangement.Center
        ) {

            PantallaInput()

            Spacer(modifier = Modifier.height(24.dp))

            Card(
                colors = CardDefaults.cardColors(FondoCardOscuro),
                shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
            ) {
                GridBotones()
            }
        }
    }
}