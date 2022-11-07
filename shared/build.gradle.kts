import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
    kotlin("multiplatform")
    id("com.android.library")
}

kotlin {
    android()
    val xcf = XCFramework()

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { target ->
        target.binaries.framework {
            baseName = "shared"
            binaryOption("bundleId", "com.vsbauer.shared")
            binaryOption("bundleVersion", "1")
            xcf.add(this)
        }
    }


    sourceSets {
        val commonMain by getting
        val androidMain by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
    }
}

android {
    namespace = "com.vsbauer.kmmconnecttes"
    compileSdk = 32
    defaultConfig {
        minSdk = 25
        targetSdk = 32
    }
    lint {
        baseline = file("lint-baseline.xml")
    }
}