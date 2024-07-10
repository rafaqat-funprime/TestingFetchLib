plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id ("maven-publish")
}

android {
    namespace = "com.tonyodev.fetch2core"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

//    implementation(libs.androidx.core.ktx)
//    implementation(libs.androidx.appcompat)
//    implementation(libs.material)
//    implementation(fileTree = "dir: 'libs', include: ['*.jar']")

    api(libs.kotlinStdLib)


    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

// Define your Maven publication configuration
afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                artifact(tasks.getByName("bundleReleaseAar"))
                // Iterate over all components and include them in the publication
//                from(components.matching { it.name == "java" || it.name == "kotlin" })


                groupId = "com.funprime.testingfetchlib"
                artifactId = "fetch2core"
                version = "1.0"
            }
        }
    }
}