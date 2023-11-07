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
    }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
rootProject.name = "catchbottle"

include (":app")

include (":core:common")
include (":core:design:core_design_resource")
include (":core:design:designsystem")
include (":core:design:ui")
include (":core:data:model:user")
include (":core:data:model:liquor")
include (":core:network:firebase:storage")
include (":core:network:firebase:remoteconfig")
include (":core:network:firebase:firestore")

include (":core:design:compose")
include (":core:domain")
include (":core:data:repository")

include (":features:screen:")
include (":features:screen:main_navigation_contents")
include (":features:screen:login")
include (":features:screen:main")



/*
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
    }
}
rootProject.name = "catchbottle"

include ':app'
include ':core:common'

include ':core:design:core_design_resource'
include ':core:design:designsystem'
include ':core:design:ui'

include ':core:data:model:user'
include ':core:data:model:liquor'

include ':core:network:firebase:storage'
include ':core:network:firebase:remoteconfig'
include ':core:network:firebase:firestore'

include ':features:screen:'
include ':features:screen:main_navigation_contents'
include ':features:screen:login'

include ':core:design:compose'
include ':features:screen:main'
include ':core:domain'
include ':core:data:repository'
*/
