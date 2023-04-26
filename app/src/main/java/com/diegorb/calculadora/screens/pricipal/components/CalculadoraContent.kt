package com.diegorb.calculadora.screens.pricipal.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun CalculadoraContent() {

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

            Spacer(modifier = Modifier.height(12.dp))

            Card(
                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primary),
                shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
            ) {
                GridBotones()
            }
        }
    }
}