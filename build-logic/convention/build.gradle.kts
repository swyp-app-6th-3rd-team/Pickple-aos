plugins {
    `kotlin-dsl`
}

group = "com.swyp.convention"

kotlin {
    jvmToolchain(21)
}

dependencies {
    implementation(libs.android.gradlePlugin)
    implementation(libs.kotlin.gradlePlugin)
    implementation(libs.compose.compiler.gradlePlugin)
}

gradlePlugin {
    plugins {
        // --- 모듈 별
        register("application") {
            id = "pickple.application"
            implementationClass = "com.swyp.pickple.ApplicationConventionPlugin"
        }
        register("feature") {
            id = "pickple.feature"
            implementationClass = "com.swyp.pickple.FeatureConventionPlugin"
        }
        // --- 플러그인
        register("lint") {
            id = "pickple.lint"
            implementationClass = "com.swyp.pickple.LintConventionPlugin"
        }
        register("common") {
            id = "pickple.common"
            implementationClass = "com.swyp.pickple.CommonConventionPlugin"
        }
    }
}