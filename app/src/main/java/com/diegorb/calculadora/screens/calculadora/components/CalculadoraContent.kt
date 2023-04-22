package com.diegorb.calculadora.screens.calculadora.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.diegorb.calculadora.screens.calculadora.CalculadoraState
import com.diegorb.calculadora.ui.theme.FondoCardOscuro

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalculadoraContent(state: CalculadoraState, modifier: Modifier = Modifier) {

    Box(contentAlignment = Alignment.BottomCenter) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center), verticalArrangement = Arrangement.Center
        ) {
            PantallaInput(state)
            Card(
                modifier = Modifier,
                colors = CardDefaults.cardColors(FondoCardOscuro),
                shape = RoundedCornerShape(24.dp)
            ) {
                GridBotones()
            }
        }




    }


}

