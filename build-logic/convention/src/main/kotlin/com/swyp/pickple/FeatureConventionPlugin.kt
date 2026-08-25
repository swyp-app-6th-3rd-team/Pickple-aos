package com.swyp.pickple

import com.swyp.pickple.extension.configureAndroidCompose
import com.swyp.pickple.extension.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

// Compose, Navigation Compose 등 화면(UI)을 그리는 데만 필요한 라이브러리
class FeatureConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("pickple.common")
            }

            configureKotlinAndroid()
            configureAndroidCompose()

            val libraryExtension = extensions.getByType(com.android.build.api.dsl.LibraryExtension::class)
            libraryExtension.apply { }

        }
    }
}