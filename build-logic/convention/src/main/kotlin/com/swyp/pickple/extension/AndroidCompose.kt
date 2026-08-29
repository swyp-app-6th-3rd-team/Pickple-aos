package com.swyp.pickple.extension

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

internal fun Project.configureAndroidCompose() {
    val commonExtension = extensions.getByType(CommonExtension::class)

    pluginManager.apply("org.jetbrains.kotlin.plugin.compose")

    commonExtension.apply {
        buildFeatures.apply{
            compose = true
        }
    }

    configureCommonDependencies()

    val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
    dependencies {
        val bom = libs.findLibrary("androidx-compose-bom").get()
        add("implementation", platform(bom))
        add("implementation", libs.findBundle("compose").get())
        add("implementation", libs.findLibrary("androidx-navigation-compose").get())
    }
}