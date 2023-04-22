package com.diegorb.calculadora

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BotonCalculadora(
    symbol: String,
    modifier: Modifier,
    color: Color = Color.White,
    icon: ImageVector? = null,
    roundness: Int = 5,
    onClick: () -> Unit

) {
    Box(
        modifier = Modifier
            .clickable { onClick }
            .clip(RoundedCornerShape(roundness.dp))
            .then(modifier) //De esta forma el modifier que pasemos por parametro se aplica a continuación
        ,
        contentAlignment = Alignment.Center,
    ){
        if(icon != null){
            Icon(imageVector = icon, contentDescription = null, tint = color)
        }else{
            Text(text = symbol, fontSize = 36.sp, color = color)
        }
    }
}