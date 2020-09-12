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

buildscript {
    repositories {
        google()
        jcenter()
        maven { url = uri("https://jitpack.io") }
        maven { url = uri("https://maven.fabric.io/public") }
        maven { url = uri("https://plugins.gradle.org/m2/") }
        maven { url = uri("http://oss.sonatype.org/content/repositories/snapshots") }
        mavenLocal()
    }

    dependencies {
        classpath ("com.android.tools.build:gradle:${Versions.Build.ANDROID_GRADLE_PLUGIN}")
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.Build.KOTLIN}")
        classpath ("com.google.gms:google-services:${Versions.Build.GOOGLE_SERVICES}")
        classpath ("com.github.triplet.gradle:play-publisher:${Versions.Build.PLAY_PUBLISHER}")
        classpath ("org.jmailen.gradle:kotlinter-gradle:${Versions.Build.KOTLINTER}")
        classpath ("com.android.tools.build:bundletool:${Versions.Build.BUNDLE_TOOL}")
        classpath ("androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.Architecture.NAVIGATION}")
        classpath ("com.google.firebase:firebase-crashlytics-gradle:${Versions.Build.CRASHLYTICS}")
        classpath ("com.google.dagger:hilt-android-gradle-plugin:${Versions.Injection.HILT}")
    }

}

allprojects {
    repositories {
        google()
        jcenter()
        maven { url = uri("https://jitpack.io") }
        maven { url = uri("https://maven.fabric.io/public") }
        maven { url = uri("https://plugins.gradle.org/m2/") }
        maven { url = uri("http://oss.sonatype.org/content/repositories/snapshots") }
        mavenLocal()
    }

    afterEvaluate  {
        tasks.withType<JavaCompile>().configureEach {
            options.compilerArgs.addAll(arrayOf("-Xmaxerrs", "10000", "-Xmaxwarns", "10000"))
        }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

subprojects {
    tasks.whenTaskAdded {
        if (name == "preBuild") {
            mustRunAfter("lintKotlin")
        }
    }
}

//apply from: "versioning.gradle"
