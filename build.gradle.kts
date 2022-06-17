import org.apache.tools.ant.filters.ReplaceTokens
import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    kotlin("jvm")
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

repositories {
    // Maven Central
    mavenCentral()

    // Paper
    maven { url = uri("https://papermc.io/repo/repository/maven-public/") }

    // Sonatype
    maven { url = uri("https://oss.sonatype.org/content/groups/public/") }

    // JitPack
    maven { url = uri("https://jitpack.io") }
}

group = "com.tatamiserver"
version = "0.1.0"
java.sourceCompatibility = JavaVersion.VERSION_17

dependencies {
    implementation(kotlin("stdlib"))

    implementation("org.jetbrains.exposed", "exposed-core", "0.38.1")
    implementation("org.jetbrains.exposed", "exposed-dao", "0.38.1")
    implementation("org.jetbrains.exposed", "exposed-jdbc", "0.38.1")

    implementation("com.github.hazae41", "mc-kutils", "master-SNAPSHOT")
    implementation("com.github.M1n1don", "SmartInvsR", "1.1")

    compileOnly("io.papermc.paper:paper-api:1.17.1-R0.1-SNAPSHOT")
}

tasks {
    named<ShadowJar>("shadowJar") {
        archiveFileName.set("StoryEditor-${project.version}.jar")
        mergeServiceFiles()
        manifest {
            attributes(mapOf("Main-Class" to "io.github.caffeinrpg.storyeditor.StoryEditorKt"))
        }
    }

    processResources {
        filteringCharset = "UTF-8"
        from(sourceSets["main"].resources.srcDirs) {
            include("**/*.yml")
            duplicatesStrategy = DuplicatesStrategy.INCLUDE
            filter<ReplaceTokens>("tokens" to mapOf("version" to project.version))
            filter<ReplaceTokens>("tokens" to mapOf("name" to project.name))
        }
    }
}

tasks {
    build {
        dependsOn(shadowJar)
    }
}