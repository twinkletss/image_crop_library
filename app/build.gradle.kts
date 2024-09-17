
plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "org.twinkle.imagecroplibraryinjava"
    compileSdk = 34

    defaultConfig {
        applicationId = "org.twinkle.imagecroplibraryinjava"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        buildConfigField("int", "RequestMode", "1")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("int", "RequestMode", "2")  // for release
        }
        debug {
            buildConfigField ("int", "RequestMode", "1") // for debug
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    defaultConfig {
        buildConfigField("int", "RequestModel", "1")
    }
    buildFeatures {
        buildConfig = true
    }

}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(project(":image_crop_library"))
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    implementation (libs.okhttp.v31213)
}