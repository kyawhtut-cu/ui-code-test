import java.util.*

plugins {
    id("com.android.application")
    id("kotlin-android")
    kotlin("kapt")
    id("com.gladed.androidgitversion") version "0.4.14"
}

val configProperties = Properties()
configProperties.load(file("${rootDir}/local.properties").inputStream())
val MAP_API_KEY: String = configProperties.getProperty("MAP_API_KEY", "")

val appName = hashMapOf(
    "debug" to "app-debug.apk",
    "release" to "app-release.apk"
)

android {
    compileSdkVersion(30)
    buildToolsVersion("30.0.2")

    defaultConfig {
        applicationId = "com.kyawhut.ui.codetest"

        minSdkVersion(19)
        targetSdkVersion(30)

        versionCode = 1
        versionName = androidGitVersion.name()

        multiDexEnabled = true

        vectorDrawables {
            useSupportLibrary = true
        }

        manifestPlaceholders["map_api_key"] = MAP_API_KEY
    }

    buildTypes {
        getByName("release") {
            debuggable(false)
            jniDebuggable(false)
            renderscriptDebuggable(false)

            minifyEnabled(true)
            isShrinkResources = true

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        dataBinding = true
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    android.applicationVariants.all {
        val variant = this
        variant.outputs.map { it as com.android.build.gradle.internal.api.BaseVariantOutputImpl }
            .forEach { output ->
                val buildOutputPath = "../../release/${variant.versionName}/%s"
                output.outputFileName = String.format(
                    buildOutputPath,
                    appName[variant.buildType.name]
                )
            }
    }
}

dependencies {

    val kotlin_version = "1.4.32"
    implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version")
    implementation("androidx.core:core-ktx:1.6.0")
    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.1")
    implementation("androidx.navigation:navigation-fragment-ktx:2.3.5")
    implementation("androidx.navigation:navigation-ui-ktx:2.3.5")
    testImplementation("junit:junit:4.+")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")

    implementation("com.google.android.gms:play-services-maps:17.0.1")

    implementation("com.github.bumptech.glide:glide:4.9.0")
    implementation("com.github.bumptech.glide:okhttp3-integration:4.4.0")
    kapt("com.github.bumptech.glide:compiler:4.9.0")
}
