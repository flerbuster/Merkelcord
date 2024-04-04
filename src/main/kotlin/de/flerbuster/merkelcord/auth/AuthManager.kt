package de.flerbuster.merkelcord.auth

import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File

object AuthManager {
    enum class AuthState {
        AddAccount,
        SelectAccount
    }

    var token: String? by mutableStateOf(null)

    var authState: AuthState by mutableStateOf(AuthState.SelectAccount)

    val isLoggedIn
        get() = token != null

    var tokenDatas: SnapshotStateList<TokenData> = mutableStateListOf()

    private val file = File("${System.getenv("APPDATA")}${File.separator}Merkelcord${File.separator}tokendata.json").also {
        if (!it.parentFile.exists()) it.parentFile.mkdirs()
        it.createNewFile()
    }

    private val json = Json { encodeDefaults = true }

    init {
        try {
            tokenDatas = read()
        } catch (e: Exception) {
            println("$e reading token data file")
            write(listOf())
        }
    }

    private fun read(): SnapshotStateList<TokenData> {
        return json.decodeFromString<List<TokenData>>(file.readText()).toMutableStateList()
    }

    private fun write(data: List<TokenData>) {
        file.writeText(json.encodeToString(data.toList()))
    }

    fun addAccount(account: TokenData) {
        tokenDatas.add(account)
        write(tokenDatas)
    }
}