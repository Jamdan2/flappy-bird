plugins {
    application
}

dependencies {
    compile(project(":core"))
}

application {
    mainClassName = "com.jamdan2.flappybird.DesktopLauncherKt"
}
