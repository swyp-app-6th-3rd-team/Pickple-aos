package com.swyp.pickple.extension

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension

internal fun Project.configureKotlinAndroid() {
    val commonExtension = extensions.getByType(CommonExtension::class)

    commonExtension.apply {
        compileSdk {
            version = release(37) {
                minorApiLevel = 1
            }
        }

        defaultConfig.apply {
            minSdk {
                version = release(26)
            }
        }
        compileOptions.apply {
            sourceCompatibility = JavaVersion.VERSION_21
            targetCompatibility = JavaVersion.VERSION_21

        }
    }

    configure<KotlinAndroidProjectExtension> {
        jvmToolchain(21)
    }
}