package com.swyp.pickple.extension

import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

// Domain을 제외한 안드로이드 모듈(App, Feature, Data)에서 쓰는 세팅
internal fun Project.configureAndroidCommon(
    includeCore: Boolean = true,
)
{
    with(pluginManager) {
        //------  core
        apply("com.google.devtools.ksp")
        //------  navigation
        apply("org.jetbrains.kotlin.plugin.parcelize")
        //------  DI
        apply("com.google.dagger.hilt.android")
        //------  Kotlinx Serialization
        apply("org.jetbrains.kotlin.plugin.serialization")
    }

    val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
    dependencies {
        //------  module
        add("implementation", project(":domain"))
        if (includeCore) {
            add("implementation", project(":core"))
        }
        //------  core
        add("implementation", libs.findBundle("android-core").get())
        //------  DI
        add("implementation", libs.findBundle("hilt").get())
        add("ksp", libs.findLibrary("hilt-compiler").get())
        //------  logging
        add("implementation", libs.findLibrary("timber").get())
    }
}