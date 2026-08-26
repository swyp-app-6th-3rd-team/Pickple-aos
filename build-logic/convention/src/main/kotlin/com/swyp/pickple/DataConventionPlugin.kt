package com.swyp.pickple

import com.swyp.pickple.extension.configureAndroidCommon
import com.swyp.pickple.extension.configureCommonPlugin
import com.swyp.pickple.extension.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

class DataConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
            }

            configureKotlinAndroid()
            configureCommonPlugin()
            configureAndroidCommon()

            val libraryExtension = extensions.getByType(com.android.build.api.dsl.LibraryExtension::class)
            libraryExtension.apply { }
        }
    }
}