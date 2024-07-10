// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
        maven { url= uri("https://jitpack.io")}
    }
    dependencies {
        classpath(libs.androidBuildTools)
        classpath(libs.jetbrainsKotlinGradlePlugin)
        classpath(libs.kspPlugin)
    }
}
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
    alias(libs.plugins.androidLibrary) apply false
}