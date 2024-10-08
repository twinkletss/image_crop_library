plugins {
    alias(libs.plugins.android.library)
    // publish library
    id ("maven-publish")
}

android {
    namespace = "org.twinkle.image_crop_library"
    compileSdk = 34

    defaultConfig {
        minSdk = 23

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        buildConfig = true
    }
}

publishing {
    publications {
        create<MavenPublication>("release") {
            // Ensure that the afterEvaluate block wraps the component selection
            afterEvaluate {
                from(components.findByName("release"))
            }

            // Set some other publishing details like groupId, artifactId, and version if needed
            groupId = "org.twinkle.image_crop_library"
            artifactId = "image_crop_library"
            version = "1.0"
        }
    }
}
dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.exifinterface)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    implementation (libs.okhttp)
}