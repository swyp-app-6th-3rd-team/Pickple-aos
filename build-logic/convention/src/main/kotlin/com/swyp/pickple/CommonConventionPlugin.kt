package com.swyp.pickple

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

// 코루틴, 코어 라이프사이클, 공통 유틸리티 등 어떤 모듈이든 99% 쓰는 라이브러리
class CommonConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                //------  core & Lifecycle  &  coroutine
                apply("com.google.devtools.ksp")
                //------  Kotlinx Serialization
                apply("org.jetbrains.kotlin.plugin.serialization")
                //------  navigation
                apply("org.jetbrains.kotlin.plugin.parcelize")
                //----- Code Quality & Analysis
                apply("io.gitlab.arturbosch.detekt")
                apply("org.jlleitschuh.gradle.ktlint")
            }

            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

            dependencies {
                add("implementation", libs.findBundle("android-core").get())
                add("implementation", libs.findLibrary("androidx-navigation-compose").get())
            }
        }
    }
}