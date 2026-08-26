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
        register("application") {
            id = "pickple.application"
            implementationClass = "com.swyp.pickple.ApplicationConventionPlugin"
        }
        register("feature") {
            id = "pickple.feature"
            implementationClass = "com.swyp.pickple.FeatureConventionPlugin"
        }
        register("data") {
            id = "pickple.data"
            implementationClass = "com.swyp.pickple.DataConventionPlugin"
        }
        register("domain") {
            id = "pickple.domain"
            implementationClass = "com.swyp.pickple.DomainConventionPlugin"
        }
    }
}