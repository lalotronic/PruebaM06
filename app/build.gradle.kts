plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.inforcap.pruebafinalv3"
    compileSdk = 35

    buildFeatures {
        buildConfig = true
    }

    defaultConfig {
        applicationId = "com.inforcap.pruebafinalv3"
        minSdk = 28
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            applicationIdSuffix = "QA"
        }
        create("qa") {
            versionNameSuffix = "Qa"
            isDebuggable = true
            buildConfigField("String", "BACKGROUND_COLOR_X", "\"#FFA500\"")
            signingConfig = signingConfigs.getByName("debug")
        }
        create("prod") {
            versionNameSuffix = "Prod"
            isDebuggable = true
            buildConfigField("String", "BACKGROUND_COLOR_X", "\"#000000\"")
        }
        create("dev") {
            versionNameSuffix = "Dev"
            isDebuggable = true
            buildConfigField("String", "BACKGROUND_COLOR_X", "\"#FFFFFF\"")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }


dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    }
}