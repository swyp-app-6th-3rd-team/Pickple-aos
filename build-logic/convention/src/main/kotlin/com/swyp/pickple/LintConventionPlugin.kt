package com.swyp.pickple

import org.gradle.api.Plugin
import org.gradle.api.Project


class LintConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("io.gitlab.arturbosch.detekt")
                apply("org.jlleitschuh.gradle.ktlint")
            }
        }
    }
}