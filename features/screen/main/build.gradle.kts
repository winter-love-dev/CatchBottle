import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.androidHilt)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.season.winter.feature.main"
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compilerVersion.get()
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
    implementation(project(":core:design:compose"))
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
    implementation(libs.androidx.fragment)

    implementation(libs.androidx.hilt.android)
    ksp(libs.androidx.hilt.android.compiler)

    implementation(libs.compose.activity)
    implementation(libs.compose.ui)
    implementation(libs.compose.navigation)
    implementation(libs.compose.foundation)
    implementation(libs.compose.material)
    implementation(libs.compose.material3)
    implementation(libs.compose.runtime)
    implementation(libs.compose.uiToolingPreview)
    implementation(libs.androidx.lifecycleRuntimeCompose)
    implementation(libs.androidx.hilt.navigation.compose)
}


/*
plugins {
    alias libs.plugins.android.library
    alias libs.plugins.kotlin.android
    alias libs.plugins.dagger.hilt
    alias libs.plugins.kotlin.kapt
    alias libs.plugins.devtools.ksp
}

android {
    namespace 'com.season.winter.feature.main'
    compileSdk libs.versions.compileSdk.get().toInteger()

    defaultConfig {
        minSdk libs.versions.minSdk.get().toInteger()

        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles "consumer-rules.pro"
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.kotlinCompilerExtensionVersion.get()
    }
}

dependencies {

    implementation project(":core:common")

    implementation project(":core:design:core_design_resource")
    implementation project(":core:design:designsystem")
    implementation project(":core:design:compose")

    implementation project(":core:data:model:liquor")

    implementation project(":core:network:firebase:storage")

    implementation project(":core:domain")

    implementation libs.bundles.default
    implementation libs.bundles.default.screen
    testImplementation libs.bundles.default.test.implementation
    androidTestImplementation libs.bundles.default.test.androidTestImplementation

    implementation libs.bundles.compose.all

    implementation libs.bundles.hilt
    kapt libs.bundles.hilt.compiler.kapt
}*/
