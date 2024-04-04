package de.flerbuster.merkelcord.auth.ui

import androidx.compose.runtime.Composable
import de.flerbuster.merkelcord.auth.AuthManager

@Composable
fun AccountManagement() {
    if (AuthManager.authState == AuthManager.AuthState.AddAccount) {
        AccountAdd()
    } else if (AuthManager.authState == AuthManager.AuthState.SelectAccount) {
        AccountSelect()
    }
}