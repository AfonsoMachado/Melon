/*
 * Copyright (c) 2019.
 * João Paulo Sena <joaopaulo761@gmail.com>
 *
 * This file is part of the UNES Open Source Project.
 *
 * UNES is licensed under the MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

object Versions {
    object Android {
        const val COMPILE_SDK = 30
        const val BUILD_TOOLS = "30.0.2"
        const val MIN_SDK = 21
        const val TARGET_SDK = COMPILE_SDK
        const val NDK_VERSION = "21.3.6528147"
    }

    object Build {
        const val KOTLIN = "1.4.10"
        const val ANDROID_GRADLE_PLUGIN = "4.0.1"
        const val GOOGLE_SERVICES = "4.3.3"
        const val PLAY_PUBLISHER = "2.7.1"
        const val KOTLINTER = "3.0.2"
        const val BUNDLE_TOOL = "0.10.0"
        const val CRASHLYTICS = "2.1.1"
    }

    object Architecture {
        const val NAVIGATION = "2.3.0"
    }

    object Injection {
        const val HILT = "2.28.3-alpha"
    }
}