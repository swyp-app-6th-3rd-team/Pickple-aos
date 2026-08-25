plugins {
    id("pickple.application")
}

android {
    namespace = "com.swyp.pickple"

    defaultConfig {
        applicationId = "com.swyp.pickple"
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
}

dependencies {
    implementation(project(":core"))
}