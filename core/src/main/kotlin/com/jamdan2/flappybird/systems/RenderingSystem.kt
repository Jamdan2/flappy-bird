package com.jamdan2.flappybird.systems

import com.badlogic.ashley.core.ComponentMapper
import com.badlogic.ashley.core.Entity
import com.badlogic.ashley.systems.IteratingSystem
import com.badlogic.ashley.core.Family
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.jamdan2.flappybird.components.PositionComponent
import com.jamdan2.flappybird.components.SpriteComponent
import org.lwjgl.util.Point
import java.awt.geom.Point2D


class RenderingSystem(val batch: SpriteBatch) : IteratingSystem(Family.all(SpriteComponent::class.java, PositionComponent::class.java).get()) {
    private val spriteMapper = ComponentMapper.getFor(SpriteComponent::class.java)
    private val positionMapper = ComponentMapper.getFor(PositionComponent::class.java)

    private val renderQueue = mutableListOf<Entity>()

    private val camera = OrthographicCamera(Gdx.graphics.width.toFloat(), Gdx.graphics.height.toFloat()).apply {
        position.set(Gdx.graphics.width / 2f, Gdx.graphics.height / 2f, 0f)
    }

    override fun update(deltaTime: Float) {
        super.update(deltaTime)
        camera.update()
        batch.projectionMatrix = camera.combined
        batch.begin()

        renderQueue.forEach {
            println("Rendering")

            val sprite = spriteMapper.get(it).sprite
            val position = positionMapper.get(it)
            batch.draw(sprite.texture, position.x, position.y)
        }

        batch.end()
        renderQueue.clear()
    }

    override fun processEntity(entity: Entity?, deltaTime: Float) {
        entity?.let { renderQueue += it }
    }
}
