import yaml.YamlLoader
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.entities.Activity
import net.dv8tion.jda.api.requests.GatewayIntent
import yaml.ResourceExporter
import java.io.File

import javax.security.auth.login.LoginException

class Main {
    companion object {
        val DIR_PATH = "${System.getProperty("user.dir")}${File.separator}config"
        lateinit var TOKEN: String
    }

    fun main(){
        loadFile()
        TOKEN = yaml.DataManager.getBotToken()
        Main().connect()
    }

    private fun loadFile() {
        ResourceExporter.export()
        YamlLoader.load("$DIR_PATH${File.separator}config.yml")
    }

    private fun connect() {
        try {
            // Login 処理
            JDABuilder.createLight(TOKEN, GatewayIntent.GUILD_MESSAGES, GatewayIntent.DIRECT_MESSAGES)
                .setActivity(Activity.playing("作業")) // "～をプレイ中" の ～の部分
                .build()
        } catch (e: LoginException) {
            e.printStackTrace()
        }
    }
}

fun main(){
    Main().main()
}