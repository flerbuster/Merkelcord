package de.flerbuster.merkelcord.ui.util

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import de.flerbuster.merkelcord.ui.coloring.colorScheme

@Composable
fun MerkelcordText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = colorScheme.primaryText,
    fontSize: TextUnit = 16.sp,
    fontStyle: FontStyle? = FontStyle.Normal,
    fontWeight: FontWeight? = FontWeight.Normal,
    fontFamily: FontFamily? = FontFamily.SansSerif,
    textAlign: TextAlign? = TextAlign.Left
) {
    Text(text, modifier, color, fontSize, fontStyle, fontWeight, fontFamily, textAlign=textAlign)
}