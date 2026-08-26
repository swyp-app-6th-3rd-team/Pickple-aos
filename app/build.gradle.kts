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
    implementation(project(":features:home"))
    implementation(project(":features:community"))
    implementation(project(":features:onboarding"))
    implementation(project(":features:mypage"))
}