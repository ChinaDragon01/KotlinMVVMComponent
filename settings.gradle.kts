pluginManagement {
    repositories {
        includeBuild("compositebuild")
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "KotlinMVVMComponent"
include(":app")
include(":base:baselib")
include(":business:home")
include(":business:community")
include(":business:mine")
