package com.swyp.pickple

import com.swyp.pickple.extension.configureAndroidCompose
import com.swyp.pickple.extension.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

// LeakCanary, Firebase Crashlytics 등 앱 전체를 감싸서 실행할 때만 필요한 도구
class ApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                //------  core
                apply("com.android.application")
                //----- 공통
                apply("pickple.common")
            }

            configureKotlinAndroid()
            configureAndroidCompose()

            val applicationExtension = extensions.getByType(com.android.build.api.dsl.ApplicationExtension::class)
            applicationExtension.apply {
                defaultConfig.apply {
                    targetSdk {
                        version = release(37)
                    }
                }
            }

            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
            dependencies {
                add("debugImplementation", libs.findLibrary("squareup-leakcanary").get())
            }
        }
    }
}