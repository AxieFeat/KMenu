import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import groovy.json.JsonSlurper
import org.gradle.kotlin.dsl.withType
import java.nio.file.Files
import java.nio.file.StandardCopyOption

plugins {
    id("com.gradleup.shadow")
    id("net.kyori.blossom")
}

sourceSets {
    main {
        blossom {
            resources {
                property("NAME", project.rootProject.name)
                property("VERSION", project.rootProject.version.toString())
                property("DESCRIPTION", project.rootProject.description)
            }
        }
    }
}

val serverVersion = "1.21.8"
val serverDirectory = "./server"
val startUpFlags = listOf("-Xmx2G", "-Xms1G")
val startUpArgs = listOf("--nogui")

val apiEntrypoint = "https://api.papermc.io/v2/"
val paperVersionsEntrypoint = "$apiEntrypoint/projects/paper/versions"

dependencies {
    // We exclude kotlin because use compileOnly(libs.kotlinStdlib) lower
    api(projects.kmenuCommon, { exclude("org.jetbrains.kotlin") })

    compileOnly(libs.paper)
    compileOnly(libs.kotlinStdlib) // We shouldn't shadow kotlin, paper download it automatically
}

tasks.withType<ShadowJar> { archiveFileName.set("kmenu.jar") }

tasks.register<JavaExec>("runServer") {
    description = "Run minecraft server with shadowed plugin"
    group = "minecraft"

    dependsOn("shadowJar")

    doFirst {
        val serverDir = file(serverDirectory)
        val pluginsDir = file("$serverDirectory/plugins")
        serverDir.mkdirs()
        pluginsDir.mkdirs()

        val eulaFile = file("$serverDirectory/eula.txt")
        if (!eulaFile.exists()) {
            eulaFile.writeText("eula=true\n")
        }

        val paperJar = file("$serverDirectory/paper.jar")
        if (!paperJar.exists()) {
            println("Downloading Paper version $serverVersion...")

            val latest = findLatestBuildInformation(serverVersion)
            val buildNumber = latest.first
            val fileName = latest.second

            val downloadUrl =
                "$paperVersionsEntrypoint/$serverVersion/builds/$buildNumber/downloads/$fileName"

            println("Download server from: $downloadUrl")

            downloadFileFromUrl(
                downloadUrl,
                paperJar
            )
            println("Server downloaded to: ${paperJar.absolutePath}")
        }

        val shadowJarTask = tasks.named<Jar>("shadowJar").get()
        val pluginJar = shadowJarTask.archiveFile.get().asFile
        val targetPluginJar = file("$serverDirectory/plugins/${pluginJar.name}")
        println("Copying plugin: ${pluginJar.name}")
        Files.copy(pluginJar.toPath(), targetPluginJar.toPath(), StandardCopyOption.REPLACE_EXISTING)
    }

    mainClass.set("io.papermc.paperclip.Main")
    classpath = files("$serverDirectory/paper.jar")
    workingDir = file(serverDirectory)

    jvmArgs = startUpFlags
    args = startUpArgs

    standardInput = System.`in`
}

private fun findLatestBuildInformation(version: String): Pair<Int, String> {
    val versionsUrl = uri("$paperVersionsEntrypoint/$version/builds").toURL()
    val versionsConnection = versionsUrl.openConnection()
    val versionsData = JsonSlurper().parse(versionsConnection.getInputStream()) as Map<*, *>
    @Suppress("UNCHECKED_CAST")
    val builds = versionsData["builds"] as List<Map<*, *>>

    val latestBuild = builds.last()
    val buildNumber = latestBuild["build"] as Int
    val downloads = latestBuild["downloads"] as Map<*, *>
    val application = downloads["application"] as Map<*, *>
    val fileName = application["name"] as String

    return buildNumber to fileName
}
