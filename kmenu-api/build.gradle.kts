plugins {
    id("io.gitlab.arturbosch.detekt")
}

dependencies {
    api(libs.adventure.api)
    api(libs.nbt)
}

setupDetekt()
setupPublishing()
