package de.flerbuster.merkelcord.ui.channel.openChannel

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.flerbuster.merkelcord.ui.coloring.colorScheme
import de.flerbuster.merkelcord.ui.util.MerkelcordText

@Composable
internal fun Messagebar(
    channelid: String,
    modifier: Modifier = Modifier,
    chatMessageValidation: (TextFieldValue) -> TextFieldValue = { it },
    onMessageChange: (String) -> Unit
) {

    var input by remember(channelid) { mutableStateOf(TextFieldValue("")) }
    val textEmpty: Boolean by derivedStateOf { input.text.isEmpty() }

    Row(
        modifier = modifier
            .padding(horizontal = 8.dp, vertical = 6.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.Bottom
    ) {

        ChatTextField(
            modifier = modifier.weight(1f),
            input = input,
            empty = textEmpty,
            onValueChange = {
                input = chatMessageValidation(it)
            }
        )

        Spacer(modifier = Modifier.width(6.dp))

        if (!textEmpty) FloatingActionButton(
            modifier = Modifier.size(48.dp),
            backgroundColor = colorScheme.textInputButtonColor,
            onClick = {
                onMessageChange(input.text)
                input = TextFieldValue("")
            }
        ) {
            Icon(
                tint = Color.White,
                imageVector = Icons.AutoMirrored.Filled.Send,
                contentDescription = null
            )
        }
    }
}



@Composable
private fun ChatTextField(
    modifier: Modifier = Modifier,
    input: TextFieldValue,
    empty: Boolean,
    onValueChange: (TextFieldValue) -> Unit
) {

    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(24.dp),
        color = colorScheme.textInputColor,
        elevation = 3.dp
    ) {
        Row(
            modifier = Modifier
                .padding(2.dp),
            verticalAlignment = Alignment.Bottom
        ) {
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Spacer(modifier = Modifier.padding(start = 15.dp))

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .heightIn(min = circleButtonSize),
                    contentAlignment = Alignment.CenterStart
                ) {

                    BasicTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        textStyle = TextStyle(
                            fontSize = 18.sp,
                            color = colorScheme.primaryText
                        ),
                        value = input,
                        onValueChange = onValueChange,
                        cursorBrush = SolidColor(colorScheme.primaryText),
                        decorationBox = { innerTextField ->
                            if (empty) {
                                MerkelcordText("Message", fontSize = 18.sp)
                            }
                            innerTextField()
                        }
                    )
                }
            }
        }
    }
}

val circleButtonSize = 44.dp
