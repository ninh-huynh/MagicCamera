plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}


android {
    compileSdk = 33

    defaultConfig {
        applicationId = "com.seu.magiccamera"
        minSdk = 21
        targetSdk = 33
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                    getDefaultProguardFile("proguard-android.txt"),
                    "proguard-rules.txt")
        }
    }
    namespace = "com.seu.magiccamera"

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":magicFilter"))
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.recyclerview)
}

