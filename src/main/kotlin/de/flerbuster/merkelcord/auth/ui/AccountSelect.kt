package de.flerbuster.merkelcord.auth.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.flerbuster.merkelcord.auth.AuthManager
import de.flerbuster.merkelcord.auth.TokenData
import de.flerbuster.merkelcord.ui.coloring.colorScheme
import de.flerbuster.merkelcord.ui.util.MerkelcordText

@Composable
fun AccountSelect() {
    val accounts = remember { AuthManager.tokenDatas }

    Column(
        modifier = Modifier.fillMaxSize().background(colorScheme.channelsBackground),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn {
            items(accounts) { account ->
                Account(account) {
                    AuthManager.token = account.token
                }
                Spacer(modifier = Modifier.height(10.dp))
            }

            item {
                OutlinedButton(onClick = {
                    AuthManager.authState = AuthManager.AuthState.AddAccount
                }, colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Color.Transparent)) {
                    MerkelcordText("account hinzufügen")
                }
            }
        }
    }
}

@Composable
private fun Account(account: TokenData, onClick: () -> Unit) {
    Row(
        modifier = Modifier.clickable(onClick=onClick),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = account.avatarPainter,
            contentDescription = account.username,
            modifier = Modifier.size(40.dp).clip(RoundedCornerShape(50))
        )

        Spacer(modifier = Modifier.width(5.dp))

        MerkelcordText(account.username, fontSize = 30.sp)
    }
}