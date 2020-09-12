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
        versionName = "1.0.0"

        ndk?.abiFilters("arm64-v8a", "armeabi", "armeabi-v7a", "mips", "mips64", "x86", "x86_64")

        ndkVersion = Versions.Android.NDK_VERSION
    }
}

dependencies {
    api(platform(project(":depconstraints")))

    implementation(Libs.KOTLIN_STDLIB)
    implementation(Libs.ANNOTATION)
}
