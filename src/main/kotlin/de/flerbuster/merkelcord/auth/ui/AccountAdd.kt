package de.flerbuster.merkelcord.auth.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import de.flerbuster.merkelcord.api.DiscordApi
import de.flerbuster.merkelcord.auth.AuthManager
import de.flerbuster.merkelcord.auth.TokenData
import de.flerbuster.merkelcord.ui.coloring.colorScheme
import de.flerbuster.merkelcord.ui.util.MerkelcordText
import kotlinx.coroutines.launch

@Composable
fun AccountAdd() {
    var token by remember { mutableStateOf("") }

    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier.fillMaxSize().background(colorScheme.channelsBackground),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(token, onValueChange = { token = it })

        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = {
            scope.launch {
                val account = getAccount(token)

                if (account != null) {
                    AuthManager.addAccount(account)
                    AuthManager.token = account.token
                }
            }
        }) {
            MerkelcordText("add account")
        }

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedButton(onClick = {
            AuthManager.authState = AuthManager.AuthState.SelectAccount
        }, colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Color.Transparent)) {
            MerkelcordText("account auswählen")
        }
    }
}

suspend fun getAccount(token: String): TokenData? {
    val api = DiscordApi(token)

    try {
        val user = api.getSelf() ?: return null

        return TokenData(user.username ?: "name", DiscordApi.userAvatar(user.id ?: "", user.avatar), token)
    } catch (e: Exception) {
        println(e)
        return null
    }
}