import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "com.jamdan2"
version = "1.0-SNAPSHOT"

val gdxVersion by extra("1.9.9")
val ktxVersion by extra("1.9.9-b1")
val ashleyVersion by extra("1.7.3")

plugins {
    idea
    kotlin("jvm") version "1.3.10"
}

buildscript {
    dependencies {
        classpath("com.badlogicgames.gdx:gdx-tools:1.9.4")
    }
}

repositories {
    mavenLocal()
    mavenCentral()
    jcenter()
    maven("https://oss.sonatype.org/content/repositories/snapshots/")
}

subprojects {
    plugins.apply("kotlin")

    repositories {
        mavenLocal()
        mavenCentral()
        jcenter()
        maven("https://oss.sonatype.org/content/repositories/snapshots/")
    }

    dependencies {
        compile(kotlin("stdlib-jdk8"))
        compile("com.badlogicgames.gdx", "gdx", gdxVersion)
        compile("com.badlogicgames.gdx", "gdx-backend-lwjgl", gdxVersion)
        compile("com.badlogicgames.gdx", "gdx-platform", gdxVersion)
        compile("com.badlogicgames.gdx", "gdx-box2d", gdxVersion)
        compile("com.badlogicgames.gdx:gdx-box2d-platform:$gdxVersion:natives-desktop")
        compile("com.badlogicgames.gdx:gdx-platform:$gdxVersion:natives-desktop")
        compile("com.badlogicgames.ashley:ashley:$ashleyVersion")
        compile("io.github.libktx", "ktx-app", ktxVersion)
        compile("io.github.libktx", "ktx-assets", ktxVersion)
        compile("io.github.libktx", "ktx-graphics", ktxVersion)
        compile("io.github.libktx", "ktx-ashley", ktxVersion)
        compile("io.github.libktx", "ktx-inject", ktxVersion)
    }
}

allprojects {
    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }
}
