pluginManagement {
    repositories {
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
        flatDir {
            dirs("libs")
        }
    }
}

rootProject.name = "Flickr"
include(":app")
include(":data")
include(":domain")
include(":presentation")
include(":domain:model")
include(":domain:usecase")
include(":data:post")
include(":presentation:wall")
include(":app:network")
include(":data:source")
include(":data:model")
