plugins {
    id("pickple.application")
    alias(libs.plugins.secrets.gradle)
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
    buildFeatures {
        buildConfig = true
    }
}
secrets {
    propertiesFileName = "local.properties"
}

dependencies {
    implementation(project(":core"))
    implementation(project(":data"))
    implementation(project(":features:home"))
    implementation(project(":features:community"))
    implementation(project(":features:onboarding"))
    implementation(project(":features:mypage"))
}