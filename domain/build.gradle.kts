plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    implementation(libs.kotlin.stdlib)
    implementation(libs.kotlin.coroutines.core)

    //hilt
    implementation(libs.hilt.core)

    //retrofit
    implementation(libs.retrofit)
    implementation(libs.retrofit.serialization.converter)
}