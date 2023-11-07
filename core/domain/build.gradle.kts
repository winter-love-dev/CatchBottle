import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.androidHilt)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.season.winter.core.domain"
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
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:data:model:liquor"))
    implementation(project(":core:data:model:user"))
    implementation(project(":core:design:ui"))
    implementation(project(":core:network:firebase:remoteconfig"))
    implementation(project(":core:network:firebase:storage"))

    implementation(libs.kotlin)
    implementation(libs.kotlin.serializationJson)
    implementation(libs.coroutines.android)

    implementation(libs.android.material)
    implementation(libs.androidx.appCompat)
    implementation(libs.androidx.core)

    ksp(libs.androidx.hilt.android.compiler)
    implementation(libs.androidx.hilt.android)

    implementation(libs.androidx.room)
    implementation(libs.androidx.room.runtime)
    ksp(libs.androidx.room.compiler)
}

/*
plugins {
    alias libs.plugins.android.library
    alias libs.plugins.kotlin.android
    alias libs.plugins.kotlin.kapt
    alias libs.plugins.dagger.hilt
}

android {
    namespace 'com.season.winter.core.domain'
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
}

dependencies {

    implementation project(":core:common")

    implementation project(":core:data:model:liquor")
    implementation project(":core:data:model:user")

    implementation project(":core:design:ui")

    implementation project(":core:network:firebase:remoteconfig")
    implementation project(":core:network:firebase:storage")

    implementation libs.bundles.default
    testImplementation libs.bundles.default.test.implementation
    androidTestImplementation libs.bundles.default.test.androidTestImplementation

    implementation libs.bundles.hilt
    kapt libs.bundles.hilt.compiler.kapt

    kapt libs.bundles.room.compiler.kapt
    annotationProcessor libs.bundles.room.compiler.annotationProcessor
    testImplementation libs.bundles.room.testing.testImplementation
    implementation libs.bundles.room

}*/
