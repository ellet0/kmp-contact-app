plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.compose")
    id("com.squareup.sqldelight")
}

val javaVersion = JavaVersion.VERSION_17

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = javaVersion.toString()
            }
        }
    }

    targets.withType(org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget::class.java) {
        binaries.withType(org.jetbrains.kotlin.gradle.plugin.mpp.Framework::class.java).all {
            export("dev.icerock.moko:mvvm-core:0.16.1")
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    val coroutinesVersion: String by project
    val ktorVersion: String by project
    val sqlDelightVersion: String by project
    val dateTimeVersion: String by project

    sourceSets {
        val commonMain by getting {
            dependencies {
                //put your multiplatform dependencies here
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material3)
                implementation(compose.materialIconsExtended)
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)

                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
//                implementation("io.ktor:ktor-client-core:$ktorVersion")
//                implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
//                implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
                implementation("com.squareup.sqldelight:runtime:$sqlDelightVersion")
                implementation("com.squareup.sqldelight:coroutines-extensions:$sqlDelightVersion")
                implementation("org.jetbrains.kotlinx:kotlinx-datetime:$dateTimeVersion")

                val mokoVersion = "0.16.1"
                implementation("dev.icerock.moko:mvvm-core:$mokoVersion")
                implementation("dev.icerock.moko:mvvm-compose:$mokoVersion")
                implementation("dev.icerock.moko:mvvm-flow:$mokoVersion")
                implementation("dev.icerock.moko:mvvm-flow-compose:$mokoVersion")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
//                implementation("io.ktor:ktor-client-android:$ktorVersion")
                implementation("com.squareup.sqldelight:android-driver:$sqlDelightVersion")
//                implementation("androidx.appcompat:appcompat:1.6.1")
//                implementation("androidx.activity:activity-ktx:1.7.2")
                implementation("androidx.activity:activity-compose:1.7.2") // for image picker
            }
        }
        val iosMain by getting {
            dependencies {
//                implementation("io.ktor:ktor-client-darwin:$ktorVersion")
                implementation("com.squareup.sqldelight:native-driver:$sqlDelightVersion")
            }
        }
    }
}

android {
    namespace = "com.ahmedhnewa.composemultiplatform"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = javaVersion
        targetCompatibility = javaVersion
    }
}

sqldelight {
    database("ContactDatabase") {
        packageName = "com.ahmedhnewa.composemultiplatform.database"
        sourceFolders = listOf("sqldelight")
    }
}


dependencies {
    implementation("androidx.core:core:1.10.1")
    commonMainApi("dev.icerock.moko:mvvm-core:0.16.1")
    commonMainApi("dev.icerock.moko:mvvm-compose:0.16.1")
    commonMainApi("dev.icerock.moko:mvvm-flow:0.16.1")
    commonMainApi("dev.icerock.moko:mvvm-flow-compose:0.16.1")
}

//dependencies {
//    implementation("androidx.core:core:1.10.1")
//    commonMainApi("dev.icerock.moko:mvvm-core:0.16.1")
//    commonMainApi("dev.icerock.moko:mvvm-compose:0.16.1")
//    commonMainApi("dev.icerock.moko:mvvm-flow:0.16.1")
//    commonMainApi("dev.icerock.moko:mvvm-flow-compose:0.16.1")
//}