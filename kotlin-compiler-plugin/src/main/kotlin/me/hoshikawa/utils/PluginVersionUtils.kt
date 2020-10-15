package me.hoshikawa.utils

import java.io.InputStreamReader
import java.util.*

object PluginVersionUtils {

    data class PluginVersionInfo (
        val groupId: String,
        val artifactId: String,
        val version: String
    )

    fun readPluginVersionInfo(): PluginVersionInfo {
        val prop = Properties()
        var inputStream = this::class.java.classLoader.getResourceAsStream("plugin-version.properties")
        if (inputStream != null) {
            prop.load(InputStreamReader(inputStream, "UTF-8"))
        }
        return PluginVersionInfo(
            prop.getProperty("groupId", "me.hoshikawa"),
            prop.getProperty("artifactId", "kotlin-compiler-plugin"),
            prop.getProperty("version", "0.0.1"))
    }

}