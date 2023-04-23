package com.diegorb.calculadora

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.diegorb.calculadora.ui.theme.FondoBotonOscuro

@Composable
fun BotonCalculadora(
    symbol: String = "",
    modifier: Modifier,
    color: Color = MaterialTheme.colorScheme.onPrimary,
    icon: Int? = null,
    roundness: Int = 8,
    onClick: () -> Unit
) {
    OutlinedButton(
        onClick = onClick,
        shape = RoundedCornerShape(roundness.dp),
        border = BorderStroke(1.dp, Color.Transparent),
        contentPadding = PaddingValues(18.dp),
        colors = ButtonDefaults.outlinedButtonColors(FondoBotonOscuro),
        modifier = modifier
            .padding(5.dp)
            .size(70.dp)
    ) {
        if (icon != null) {
            Image(painter = painterResource(id = icon), contentDescription = null, colorFilter = ColorFilter.tint(color), modifier = Modifier.size(28.dp))
        } else {
            Text(text = symbol, fontSize = 24.sp, color = color)
        }
    }
}