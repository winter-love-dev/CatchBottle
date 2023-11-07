import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.androidHilt)
    alias(libs.plugins.ksp)
    alias(libs.plugins.kapt)
}

android {
    namespace = "com.season.winter.main_navigation_contents"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
    viewBinding {
        enable = true
    }
    dataBinding {
        enable = true
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(project(":core:common"))
    implementation(project(":core:design:core_design_resource"))
    implementation(project(":core:design:designsystem"))
    implementation(project(":core:design:ui"))
    implementation(project(":core:data:model:liquor"))
    implementation(project(":core:network:firebase:storage"))
    implementation(project(":core:domain"))

    implementation(libs.kotlin)
    implementation(libs.kotlin.serializationJson)
    implementation(libs.coroutines.android)

    implementation(libs.android.material)
    implementation(libs.androidx.appCompat)
    implementation(libs.androidx.core)
    implementation(libs.androidx.lifecycle.viewModel)
    implementation(libs.androidx.recyclerView)
    implementation(libs.androidx.constraintLayout)
    implementation(libs.androidx.viewpager2)
    implementation(libs.androidx.fragment)
    implementation(libs.androidx.navigation.fragment)

    implementation(libs.androidx.hilt.android)
    ksp(libs.androidx.hilt.android.compiler)

    annotationProcessor(libs.glideAnnotationProcessor)
    implementation(libs.glide)
}

/*
plugins {
    alias libs.plugins.android.library
    alias libs.plugins.kotlin.android
    alias libs.plugins.kotlin.kapt
    alias libs.plugins.devtools.ksp
    alias libs.plugins.dagger.hilt
}

android {
    namespace 'com.season.winter.main_navigation_contents'
    compileSdk libs.versions.compileSdk.get().toInteger()

    defaultConfig {
        minSdk libs.versions.minSdk.get().toInteger()
        targetSdk libs.versions.targetSdk.get().toInteger()

        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
    dataBinding {
        enabled = true
    }
}

dependencies {

    implementation project(":core:common")

    implementation project(":core:design:core_design_resource")
    implementation project(":core:design:designsystem")
    implementation project(":core:design:ui")

    implementation project(":core:data:model:liquor")

    implementation project(":core:network:firebase:storage")

    implementation project(":core:domain")

    implementation libs.bundles.default
    implementation libs.bundles.default.screen
    implementation libs.bundles.navigation
    testImplementation libs.bundles.default.test.implementation
    androidTestImplementation libs.bundles.default.test.androidTestImplementation

    implementation libs.bundles.hilt
    kapt libs.bundles.hilt.compiler.kapt

    kapt libs.bundles.glide.compiler.annotationProcessor
    implementation libs.bundles.glide
}
*/
