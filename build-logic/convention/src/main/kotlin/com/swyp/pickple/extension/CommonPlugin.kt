package com.swyp.pickple.extension

import org.gradle.api.Project

// Domain, Data, Feature, App 가리지 않고 '모두' 쓰는 플러그인
internal fun Project.configureCommonPlugin() {
    with(pluginManager) {
        //------  Kotlinx Serialization
        apply("org.jetbrains.kotlin.plugin.serialization")
        //----- Code Quality & Analysis
        apply("io.gitlab.arturbosch.detekt")
        apply("org.jlleitschuh.gradle.ktlint")
    }
}