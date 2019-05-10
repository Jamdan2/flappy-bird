package com.jamdan2.flappybird

import com.badlogic.ashley.core.Engine
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.jamdan2.flappybird.components.PositionComponent
import com.jamdan2.flappybird.components.SpriteComponent
import ktx.ashley.entity

class World(val engine: Engine) {
    val xSpawn = 0f
    val ySpawn = 0f

    fun createBird() {
        engine.entity {
            entity.apply {
                add(SpriteComponent(Sprite(Texture("bird.png"))))
                add(PositionComponent(xSpawn, ySpawn))
            }
        }
    }

    init {
        createBird()
    }
}
