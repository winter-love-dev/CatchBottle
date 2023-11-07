// Top-level build file where you can add configuration options common to all sub-projects/modules.
@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidApp) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.kotlinAndroid) apply false
    alias(libs.plugins.kotlinSerialization) apply false
    alias(libs.plugins.androidHilt) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.kapt) apply false
    alias(libs.plugins.googleServicesGms) apply false
}
true // Needed to make the Suppress annotation work for the plugins block

// Top-level build file where you can add configuration options common to all sub-projects/modules.
/*
plugins {
    alias libs.plugins.android.application apply false
    alias libs.plugins.android.library apply false
    alias libs.plugins.kotlin.android apply false
    alias libs.plugins.kotlin.kapt apply false
    alias libs.plugins.dagger.hilt apply false
    alias libs.plugins.devtools.ksp apply false
    alias libs.plugins.gms.google.services apply false
}
*/
