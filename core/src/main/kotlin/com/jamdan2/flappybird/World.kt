package com.jamdan2.flappybird

import com.badlogic.ashley.core.Engine
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.jamdan2.flappybird.components.*
import ktx.ashley.entity

class World(private val engine: Engine) {
    private val xSpawn = Gdx.graphics.width.toFloat() / 4
    private val ySpawn = Gdx.graphics.height.toFloat() / 2

    fun createBird() {
        engine.entity {
            entity.apply {
                val texture = Texture("bird.png")
                add(VisualComponent(Sprite(texture), true))
                add(PositionComponent(xSpawn, ySpawn, 0f, texture.width.toFloat(), texture.height.toFloat()))
                add(DeltaComponent(10f, 0f))
                add(ControlComponent(false))
            }
        }
    }
}
