package me.hoshikawa.kotlin

import com.google.auto.service.AutoService
import org.jetbrains.kotlin.com.intellij.mock.MockProject
import org.jetbrains.kotlin.compiler.plugin.ComponentRegistrar
import org.jetbrains.kotlin.config.CompilerConfiguration

@AutoService(ComponentRegistrar::class)
class KotlinCompilerPlugin : ComponentRegistrar {

    override fun registerProjectComponents(
        project: MockProject,
        configuration: CompilerConfiguration
    ) {
        if (configuration[KEY_ENABLED] == false) {
            return
        }

//        Implementation your plugin extension
//        ExpressionCodegenExtension.registerExtension(
//            project,
//            object: ExpressionCodegenExtension {
//
//            }
//        )

    }

}