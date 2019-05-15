package com.jamdan2.flappybird

import com.badlogic.ashley.core.Engine
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.jamdan2.flappybird.components.PositionComponent
import com.jamdan2.flappybird.components.SpriteComponent
import ktx.ashley.entity

class World(private val engine: Engine) {
    private val xSpawn = Gdx.graphics.width.toFloat() / 2
    private val ySpawn = Gdx.graphics.height.toFloat() / 2

    fun createBird() {
        engine.entity {
            entity.apply {
                add(SpriteComponent(Sprite(Texture("bird.png"))))
                add(PositionComponent(xSpawn, ySpawn))
            }
        }
    }
}
