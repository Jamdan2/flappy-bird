package com.jamdan2.flappybird

import com.badlogic.ashley.core.Engine
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.jamdan2.flappybird.components.*
import ktx.ashley.entity

class World(private val engine: Engine) {
    private val xSpawn: Float = Gdx.graphics.width.toFloat() / 4
    private val ySpawn: Float = Gdx.graphics.height.toFloat() / 2

    val firstPipe: Float = Gdx.graphics.width.toFloat() * .75f
    val pipeSpacer: Float = Gdx.graphics.width.toFloat() / 3
    val minimumGateBottom: Float = 100f
    val maximumGateTop: Float = Gdx.graphics.height.toFloat() - 100
    val gateSize: Float = 350f

    fun createBird() {
        engine.entity {
            entity.apply {
                val texture = Texture("bird.png")
                add(VisualComponent(texture, center = true))
                add(PositionComponent(xSpawn, ySpawn, 1f, texture.width.toFloat() / 2, texture.height.toFloat() / 2))
                add(DeltaComponent(10f, 0f))
                add(ControlComponent(false))
            }
        }
    }

    fun createPipe(x: Float, y: Float, height: Float, upsideDown: Boolean = false) {
        engine.entity {
            entity.apply {
                val texture = Texture("pipe.png")
                add(VisualComponent(texture, stretchBottomOnly = true))
                add(PositionComponent(
                        x = x,
                        y = y,
                        z = -1f,
                        width = texture.width.toFloat(),
                        height = height,
                        angle = if (upsideDown) 180f else 0f,
                        flipX = upsideDown
                ))
            }
        }
    }

    fun createPipeGate(x: Float, bottomY: Float, topY: Float) {
        createPipe(x, bottomY / 2f, bottomY, false)
        createPipe(x, Gdx.graphics.height - (Gdx.graphics.height - topY) / 2, Gdx.graphics.height - topY, true)
    }
}
