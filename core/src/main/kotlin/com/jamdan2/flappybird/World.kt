package com.jamdan2.flappybird

import com.badlogic.ashley.core.Engine
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.jamdan2.flappybird.components.*
import ktx.ashley.entity

class World(private val engine: Engine) {
    private val xSpawn = Gdx.graphics.width.toFloat() / 4
    private val ySpawn = Gdx.graphics.height.toFloat() / 2

    fun createBird() {
        engine.entity {
            entity.apply {
                val texture = Texture("bird.png")
                add(SimpleVisualComponent(texture, center = true))
                add(PositionComponent(xSpawn, ySpawn, 1f, texture.width.toFloat(), texture.height.toFloat()))
                add(DeltaComponent(10f, 0f))
                add(ControlComponent(false))
            }
        }
    }

    fun createPipe() {
        engine.entity {
            entity.apply {
                val texture = Texture("pipe.png")
                add(SimpleVisualComponent(texture, stretchBottomOnly = true))
                add(PositionComponent(500f, 500f, -1f, texture.width.toFloat(), 500f, angle = 180f, flipX = true))
            }
        }
    }
}
