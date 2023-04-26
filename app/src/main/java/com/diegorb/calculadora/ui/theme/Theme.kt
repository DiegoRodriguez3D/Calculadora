package com.diegorb.calculadora.ui.theme

import android.app.Activity
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat

private val DarkColorScheme = darkColorScheme(
    primary = FondoCardOscuro,
    secondary = FondoBotonOscuro,
    tertiary = Color.White,
    background = FondoOscuro,
)

private val LightColorScheme = lightColorScheme(
    primary = FondoCardClaro,
    secondary = FondoBotonClaro,
    tertiary = Color.Black,
    background = FondoClaro,
)

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun CalculadoraTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            if (darkTheme) {
                (view.context as Activity).window.statusBarColor = FondoOscuro.toArgb()
                (view.context as Activity).window.navigationBarColor = FondoCardOscuro.toArgb()
                ViewCompat.getWindowInsetsController(view)?.isAppearanceLightStatusBars = !darkTheme
                ViewCompat.getWindowInsetsController(view)?.isAppearanceLightNavigationBars =
                    !darkTheme
            } else {
                (view.context as Activity).window.statusBarColor = FondoClaro.toArgb()
                (view.context as Activity).window.navigationBarColor = FondoCardClaro.toArgb()
                ViewCompat.getWindowInsetsController(view)?.isAppearanceLightStatusBars = !darkTheme
                ViewCompat.getWindowInsetsController(view)?.isAppearanceLightNavigationBars =
                    !darkTheme
            }
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}