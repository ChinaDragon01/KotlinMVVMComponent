package com.example.compositebuild

import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.project

/**
 *Author: chinadragon
 *Time: 2024/5/21
 */

class AppGradlePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {

            plugins.run {

                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
                apply("com.google.devtools.ksp")
            }

            extensions.configure<ApplicationExtension> {

                namespace = "com.example.kotlinmvvmcomponent"
                compileSdk = Versions.compileSdk

                defaultConfig {
                    applicationId = "com.example.kotlinmvvmcomponent"
                    minSdk = Versions.minSdk
                    targetSdk = Versions.targetSdk
                    versionCode = Versions.versionCode
                    versionName = Versions.versionName

                    testInstrumentationRunner = CommonDefaultConfig.testInstrumentationRunner
                }

                buildTypes {
                    release {
                        isMinifyEnabled = false
                        proguardFiles(
                            getDefaultProguardFile("proguard-android-optimize.txt"),
                            "proguard-rules.pro"
                        )
                    }
                }
                compileOptions {
                    sourceCompatibility = JavaVersions.sourceCompatibility
                    targetCompatibility = JavaVersions.targetCompatibility
                }
                kotlinOptions {
                    jvmTarget = JavaVersions.jvmTarget
                }
                buildFeatures{
                    dataBinding = true
                }
            }

            dependencies {
                if (!BusinessModuleDebug.isBusinessModuleDebug){
                    "implementation"(project(":business:home"))
                    "implementation"(project(":business:community"))
                    "implementation"(project(":business:mine"))
                }
                "implementation"(project(":base:baselib"))
                testLib()
            }
        }
    }
}