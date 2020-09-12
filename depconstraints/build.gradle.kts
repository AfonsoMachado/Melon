/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

plugins {
    id("java-platform")
    id("maven-publish")
}

val appcompat = "1.2.0"
val annotation = "1.1.0"
val activity = "1.0.0"
val hilt = Versions.Injection.HILT
val hiltJetPack = "1.0.0-alpha02"
val juice = "1.6.0"
val coreKtx = "1.5.0-alpha02"
val swipeRefresh = "1.1.0"
val constraintLayout = "2.0.1"
val material = "1.2.1"
val palette = "1.0.0"
val browser = "1.2.0"
val preferences = "1.1.1"


dependencies {
    constraints {
        api("${Libs.ANDROIDX_HILT_COMPILER}:$hiltJetPack")
        api("${Libs.ANNOTATION}:$annotation")
        api("${Libs.APPCOMPAT}:$appcompat")
        api("${Libs.KOTLIN_STDLIB}:${Versions.Build.KOTLIN}")
        api("${Libs.JUICE}:$juice")
        api("${Libs.CORE_KTX}:$coreKtx")
        api("${Libs.SWIPE_REFRESH}:$swipeRefresh")
        api("${Libs.CONSTRAINT_LAYOUT}:$constraintLayout")
        api("${Libs.MATERIAL}:$material")
        api("${Libs.PALETTE}:$palette")
        api("${Libs.BROWSER}:$browser")
        api("${Libs.PREFERENCES}:$preferences")
    }
}

publishing {
    publications {
        create<MavenPublication>("myPlatform") {
            from(components["javaPlatform"])
        }
    }
}
