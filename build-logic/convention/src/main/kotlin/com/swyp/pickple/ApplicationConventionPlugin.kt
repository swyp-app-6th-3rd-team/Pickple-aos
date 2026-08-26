package com.swyp.pickple

import com.swyp.pickple.extension.configureAndroidCommon
import com.swyp.pickple.extension.configureAndroidCompose
import com.swyp.pickple.extension.configureCommonPlugin
import com.swyp.pickple.extension.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class ApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
            }

            configureKotlinAndroid()
            configureCommonPlugin()
            configureAndroidCommon()
            configureAndroidCompose()

            val applicationExtension = extensions.getByType(com.android.build.api.dsl.ApplicationExtension::class)
            applicationExtension.apply {
                defaultConfig.apply {
                    targetSdk { version = release(37) }
                }
            }

            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
            dependencies {
                add("debugImplementation", libs.findLibrary("squareup-leakcanary").get())
            }
        }
    }
}