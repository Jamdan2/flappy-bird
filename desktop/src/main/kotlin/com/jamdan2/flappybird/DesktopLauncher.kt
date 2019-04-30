package com.jamdan2.flappybird

import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration

fun main() {
    LwjglApplication(Game, LwjglApplicationConfiguration().apply {
        title = "Flappy Bird"
        width = 2400
        height = 1600
        resizable = false
    })
}
