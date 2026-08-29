package com.swyp.pickple.extension


import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

// Domain, Data, Feature 등 '모든' 모듈에 공통으로 들어가는 의존성
internal fun Project.configureCommonDependencies() {
    val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

    dependencies {
        //------ coroutine
        add("implementation", libs.findLibrary("kotlinx-coroutines-core").get())
        //------ DI
        add("implementation", libs.findLibrary("javax-inject").get())
    }
}