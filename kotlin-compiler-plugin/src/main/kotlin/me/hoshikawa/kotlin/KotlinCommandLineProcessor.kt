package me.hoshikawa.kotlin;

import com.google.auto.service.AutoService
import me.hoshikawa.WrapGradleSubPlugin.Companion.ARTIFACT_NAME
import org.jetbrains.kotlin.compiler.plugin.AbstractCliOption
import org.jetbrains.kotlin.compiler.plugin.CliOption
import org.jetbrains.kotlin.compiler.plugin.CommandLineProcessor
import org.jetbrains.kotlin.config.CompilerConfiguration
import org.jetbrains.kotlin.config.CompilerConfigurationKey

@AutoService(CommandLineProcessor::class)
class ActualKotlinCommandLineProcessor : CommandLineProcessor {
  /**
   * Just needs to be consistent with the key for DebugLogGradleSubplugin#getCompilerPluginId
   */
  override val pluginId: String = ARTIFACT_NAME

  /**
   * Should match up with the options we return from our DebugLogGradleSubplugin.
   * Should also have matching when branches for each name in the [processOption] function below
   */
  override val pluginOptions: Collection<CliOption> = listOf(
      CliOption(
          optionName = "enable", valueDescription = "<true|false>",
          description = "whether to enable the plugin or not"
      )
  )

    override fun processOption(option: AbstractCliOption, value: String, configuration: CompilerConfiguration) {
        println("value: $value")
        when (option.optionName) {
            "enable" -> configuration.put(KEY_ENABLED, value.toBoolean())
            else -> error("Unexpected config option ${option.optionName}")
        }
    }
}

val KEY_ENABLED = CompilerConfigurationKey<Boolean>("whether the plugin is enabled")