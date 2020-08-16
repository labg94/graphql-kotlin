package com.lbenavides.graphqlkotlin.config

import MonadHooks
import com.expediagroup.graphql.SchemaGeneratorConfig
import org.springframework.context.annotation.Configuration

@Configuration
class HookConfig {

    val configWithReactorMonoMonad: SchemaGeneratorConfig = SchemaGeneratorConfig(
            supportedPackages = listOf("graphqlkotlin","model","services"),
            hooks = MonadHooks()
    )
}