/*
 * This file is part of the UNES Open Source Project.
 * UNES is licensed under the GNU GPLv3.
 *
 * Copyright (c) 2020. João Paulo Sena <joaopaulo761@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
    id("org.jmailen.kotlinter")
}

android {
    compileSdkVersion(Versions.Android.COMPILE_SDK)
    buildToolsVersion(Versions.Android.BUILD_TOOLS)

    defaultConfig {
        minSdkVersion(Versions.Android.MIN_SDK)
        targetSdkVersion(Versions.Android.TARGET_SDK)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    buildFeatures {
        dataBinding = true
    }

    compileOptions {
        targetCompatibility = JavaVersion.VERSION_1_8
        sourceCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        val options = this as org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions
        options.jvmTarget = "1.8"
    }

}

dependencies {
    api(platform(project(":depconstraints")))
    kapt(platform(project(":depconstraints")))

    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))


    implementation(Libs.KOTLIN_STDLIB)
    implementation(Libs.KOTLIN_REFLECT)

    implementation(Libs.JUICE)

    // Android X
    implementation(Libs.CORE_KTX)
    implementation(Libs.ANNOTATION)
    implementation(Libs.APPCOMPAT)
    implementation(Libs.SWIPE_REFRESH)
    implementation(Libs.CONSTRAINT_LAYOUT)
    implementation(Libs.MATERIAL)
    implementation(Libs.PALETTE)
    implementation(Libs.BROWSER)
    implementation(Libs.PREFERENCES)
    implementation "com.google.android:flexbox:$flexbox"
    implementation "androidx.fragment:fragment:$fragment"
    implementation "androidx.fragment:fragment-ktx:$fragment"
    implementation 'com.google.guava:listenablefuture:9999.0-empty-to-avoid-conflict-with-guava'

    // Architecture
    api "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle"
    api "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle"
    api "androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle"
    api "androidx.lifecycle:lifecycle-extensions:$lifecycle"
    api "androidx.lifecycle:lifecycle-common-java8:$lifecycle"

    implementation "com.jakewharton.timber:timber:$timber"

    api "androidx.navigation:navigation-ui-ktx:$navigation"
    api "androidx.navigation:navigation-fragment-ktx:$navigation"

    // Work manager
    api "androidx.work:work-runtime:$work_manager"
    api "androidx.work:work-runtime-ktx:$work_manager"
    api "androidx.work:work-gcm:$work_manager"

    api "androidx.room:room-runtime:$room"
    api "androidx.room:room-ktx:$room"

    // Image
    api "com.github.bumptech.glide:glide:$glide"
    kapt "com.github.bumptech.glide:compiler:$glide"
    api "com.theartofdev.edmodo:android-image-cropper:$image_cropper"

    api "com.wdullaer:materialdatetimepicker:$date_time_picker"

    // Networking
    api "com.squareup.okhttp3:okhttp:$okhttp"
    api "com.squareup.okhttp3:logging-interceptor:$okhttp"
    api "com.squareup.retrofit2:retrofit:$retrofit"
    api "com.squareup.retrofit2:converter-gson:$retrofit"
    api "com.github.franmontiel:PersistentCookieJar:$cookie_jar"

    api "com.google.dagger:dagger:$dagger"
    kapt "com.google.dagger:dagger-compiler:$dagger"
}
