package de.flerbuster.merkelcord.ui.util

import androidx.compose.foundation.LocalScrollbarStyle
import androidx.compose.foundation.VerticalScrollbar
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.rememberScrollbarAdapter
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import de.flerbuster.merkelcord.ui.coloring.colorScheme

@Composable
fun MerkelcordVerticalScrollbar(
    state: LazyListState,
    width: Dp = 5.dp
) {
    VerticalScrollbar(
        modifier = Modifier.fillMaxHeight().background(colorScheme.scrollbarColor),
        adapter = rememberScrollbarAdapter(
            scrollState = state
        ),
        style = LocalScrollbarStyle.current.copy(
            unhoverColor = colorScheme.scrollbarThumbColor,
            hoverColor = colorScheme.scrollbarThumbHoverColor,
            thickness = width
        )
    )
}