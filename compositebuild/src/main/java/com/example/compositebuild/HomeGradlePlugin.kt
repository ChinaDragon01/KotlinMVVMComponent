package com.example.compositebuild

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.named
import org.gradle.kotlin.dsl.project

/**
 *Author: chinadragon
 *Time: 2024/5/26
 */
class HomeGradlePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            plugins.run {
                if (BusinessModuleDebug.isBusinessModuleDebug) {
                    apply("com.android.application")
                } else {
                    apply("com.android.library")
                }
                apply("org.jetbrains.kotlin.android")
                apply("com.google.devtools.ksp")

            }
            if (BusinessModuleDebug.isBusinessModuleDebug) {
                extensions.configure<ApplicationExtension> {

                    namespace = "com.example.home"
                    compileSdk = Versions.compileSdk

                    defaultConfig {
                        applicationId = "com.example.home"
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
                    buildFeatures {
                        dataBinding = true
                    }
                    sourceSets {
                        named("main") {
                            manifest.srcFile("src/main/debug/AndroidManifest.xml")
                        }
                    }
                }


            } else {
                extensions.configure<LibraryExtension> {
                    namespace = "com.example.home"
                    compileSdk = Versions.compileSdk

                    defaultConfig {
                        minSdk = Versions.minSdk

                        testInstrumentationRunner = CommonDefaultConfig.testInstrumentationRunner
                        consumerProguardFiles("consumer-rules.pro")
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
                    buildFeatures {
                        dataBinding = true
                    }
                }
            }

            dependencies {
                "implementation"(project(":base:baselib"))
                testLib()
            }
        }
    }
}
