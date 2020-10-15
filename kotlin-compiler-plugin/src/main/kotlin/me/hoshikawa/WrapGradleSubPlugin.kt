package me.hoshikawa

import com.google.auto.service.AutoService
import me.hoshikawa.utils.PluginVersionUtils
import org.jetbrains.kotlin.gradle.plugin.*
import org.gradle.api.provider.Provider

@AutoService(KotlinCompilerPluginSupportPlugin::class)
class WrapGradleSubPlugin : KotlinCompilerPluginSupportPlugin {

    companion object {
        const val ARTIFACT_GROUP_NAME = "me.hoshikawa"
        const val ARTIFACT_NAME = "kotlin-compiler-plugin"
        const val ARTIFACT_VERSION = "0.0.1"
    }

    override fun isApplicable(kotlinCompilation: KotlinCompilation<*>): Boolean =
        kotlinCompilation.target.project.plugins.hasPlugin(WrapGradleSubPlugin::class.java)

    override fun applyToCompilation(kotlinCompilation: KotlinCompilation<*>): Provider<List<SubpluginOption>> {
        val project = kotlinCompilation.target.project
        System.out.println("tstasd")
        System.out.println(PluginVersionUtils.readPluginVersionInfo())
        return project.provider {
            listOf(SubpluginOption("enable", "true"))
        }
    }

    override fun getPluginArtifact(): SubpluginArtifact =
        SubpluginArtifact(ARTIFACT_GROUP_NAME, ARTIFACT_NAME, ARTIFACT_VERSION)

    override fun getCompilerPluginId() = ARTIFACT_NAME

}