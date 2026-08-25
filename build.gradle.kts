// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    //------  core & Lifecycle  &  coroutine
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.google.ksp) apply false
    alias(libs.plugins.jetbrains.kotlin.jvm) apply false
    //------  Kotlinx Serialization
    alias(libs.plugins.kotlin.serialization) apply false
    //------  navigation
    alias(libs.plugins.kotlin.parcelize) apply false
    //------  DI
    alias(libs.plugins.hilt.gradle) apply false
    //----- secrets plugin
    alias(libs.plugins.secrets.gradle) apply false
    //----- Code Quality & Analysis
    alias(libs.plugins.detekt) apply false
}