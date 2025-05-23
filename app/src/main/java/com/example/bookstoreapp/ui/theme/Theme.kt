package com.example.bookstoreapp.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape

private val DarkAcademyColorPalette = darkColorScheme(
    primary = Color(0xFF5C4D3C),       // Brun foncé (bordures, boutons)
    onPrimary = Color(0xFFE8D5B5),     // Crème doré (texte sur éléments primaires)
    primaryContainer = Color(0xFF3A3328), // Fond des cartes
    onPrimaryContainer = Color(0xFFE8D5B5), // Texte sur fond primaire
    secondary = Color(0xFF8B7C65),     // Brun clair (sous-titres)
    onSecondary = Color(0xFF121212),   // Texte sur éléments secondaires
    surface = Color(0xFF1E1E1E),       // Fond des surfaces
    onSurface = Color(0xFFE8D5B5),     // Texte principal
    background = Color(0xFF121212),    // Fond d'écran
    onBackground = Color(0xFFB8A282)   // Texte secondaire
)

private val AcademyFontFamily = FontFamily.Default // Remplacez par votre police custom si nécessaire

private val DarkAcademyTypography = Typography(
    displayLarge = TextStyle(
        fontFamily = AcademyFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        color = Color(0xFFE8D5B5)
    ),
    titleLarge = TextStyle(
        fontFamily = AcademyFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
        letterSpacing = 0.5.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = AcademyFontFamily,
        fontSize = 16.sp,
        lineHeight = 24.sp
    ),
    labelSmall = TextStyle(
        fontFamily = AcademyFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        color = Color(0xFF8B7C65)
    )
)

@Composable
fun BookStoreAppTheme(
    darkTheme: Boolean = true, // Forcé en mode sombre pour Dark Academy
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkAcademyColorPalette
    } else {
        DarkAcademyColorPalette // Même palette en mode clair (optionnel)
    }

    MaterialTheme(
        colorScheme = colors,
        typography = DarkAcademyTypography,
        shapes = MaterialTheme.shapes.copy(
            small = RoundedCornerShape(4.dp),  // Boutons, champs
            medium = RoundedCornerShape(8.dp), // Cartes
            large = RoundedCornerShape(12.dp)  // Modals
        ),
        content = content
    )
}