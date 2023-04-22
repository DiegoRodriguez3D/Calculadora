package com.diegorb.calculadora

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BotonCalculadora(
    symbol: String,
    modifier: Modifier,
    color: Color = MaterialTheme.colorScheme.onPrimary,
    icon: ImageVector? = null,
    roundness: Int = 8,
    onClick: () -> Unit
) {
    OutlinedButton(
        onClick = onClick,
        shape = RoundedCornerShape(roundness.dp),
        border = BorderStroke(1.dp, Color.Transparent),
        contentPadding = PaddingValues(18.dp),
        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.background),
        modifier = modifier.padding(5.dp).size(70.dp)
    ) {
        if (icon != null) {
            Icon(imageVector = icon, contentDescription = null, tint = color)
        } else {
            Text(text = symbol, fontSize = 24.sp, color = color)
        }

    }
}