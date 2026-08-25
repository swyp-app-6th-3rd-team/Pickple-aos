plugins {
    //------  core & Lifecycle  &  coroutine
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.google.ksp)
    //------  Kotlinx Serialization
    alias(libs.plugins.kotlin.serialization)
    //------  navigation
    alias(libs.plugins.kotlin.parcelize)
    //----- Code Quality & Analysis
    alias(libs.plugins.detekt)
}

android {
    namespace = "com.swyp.pickple"
    compileSdk {
        version = release(37) {
            minorApiLevel = 1
        }
    }

    defaultConfig {
        applicationId = "com.swyp.pickple"
        minSdk = 26
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            optimization {
                enable = false
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    buildFeatures {
        compose = true
    }
}
kotlin {
    jvmToolchain(21)
}

dependencies {
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.bundles.android.core)
    implementation(libs.bundles.compose)

    debugImplementation(libs.squareup.leakcanary)
}