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

class RenderingSystem(val batch: SpriteBatch) : IteratingSystem(Family.all(SpriteComponent::class.java, PositionComponent::class.java).get()) {
    private val spriteMapper = ComponentMapper.getFor(SpriteComponent::class.java)
    private val positionMapper = ComponentMapper.getFor(PositionComponent::class.java)

    private val renderQueue = mutableListOf<Entity>()

    val camera = OrthographicCamera(Gdx.graphics.width.toFloat(), Gdx.graphics.height.toFloat()).apply {
        position.set(Gdx.graphics.width / 2f, Gdx.graphics.height / 2f, 0f)
    }

    override fun update(deltaTime: Float) {
        super.update(deltaTime)
        camera.update()
        batch.projectionMatrix = camera.combined
        batch.begin()

        renderQueue.sortBy { positionMapper.get(it).z }

        renderQueue.forEach {
            val sprite = spriteMapper.get(it)
            val position = positionMapper.get(it)
            batch.draw(
                    sprite.sprite.texture,
                    position.x - (position.width / 2),
                    position.y - (position.height / 2),
                    position.width,
                    position.height
            )
        }

        batch.end()
        renderQueue.clear()
    }

    override fun processEntity(entity: Entity?, deltaTime: Float) {
        entity?.let { renderQueue += it }
    }
}
