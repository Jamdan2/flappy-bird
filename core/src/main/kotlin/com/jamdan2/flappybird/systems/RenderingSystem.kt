package com.jamdan2.flappybird.systems

import com.badlogic.ashley.core.ComponentMapper
import com.badlogic.ashley.core.Entity
import com.badlogic.ashley.systems.IteratingSystem
import com.badlogic.ashley.core.Family
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.jamdan2.flappybird.components.*

class RenderingSystem(val batch: SpriteBatch) : IteratingSystem(Family.all(SimpleVisualComponent::class.java, PositionComponent::class.java).get()) {
    private val spriteMapper = ComponentMapper.getFor(SimpleVisualComponent::class.java)
    private val positionMapper = ComponentMapper.getFor(PositionComponent::class.java)
    private val deltaMapper = ComponentMapper.getFor(DeltaComponent::class.java)

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
            val visual = spriteMapper.get(it)
            val position = positionMapper.get(it)
            if (visual.center && position.x > camera.position.x) camera.position.x = position.x
            if (visual.stretchBottomOnly) {
                batch.draw(
                        TextureRegion(
                                visual.texture,
                                0,
                                0,
                                visual.texture.width,
                                visual.texture.height / 2
                        ).apply { flip(position.flipX, position.flipY) },
                        position.x - (position.width / 2),
                        (position.y - (position.height / 2)) + (position.height - (visual.texture.height / 2)),
                        (position.width / 2),
                        (position.height / 2) - (position.height - visual.texture.height / 2),
                        position.width,
                        (visual.texture.height / 2).toFloat(),
                        1f,
                        1f,
                        position.angle
                )
                batch.draw(
                        TextureRegion(
                                visual.texture,
                                0,
                                visual.texture.height / 2,
                                position.width.toInt(),
                                visual.texture.height / 2
                        ).apply { flip(position.flipX, position.flipY) },
                        position.x - (position.width / 2),
                        position.y - (position.height / 2),
                        (position.width / 2),
                        (position.height / 2),
                        position.width,
                        position.height - (visual.texture.height / 2).toFloat(),
                        1f,
                        1f,
                        position.angle
                )
            } else {
                batch.draw(
                        visual.texture,
                        position.x - (position.width / 2),
                        position.y - (position.height / 2),
                        (position.width / 2),
                        (position.height / 2),
                        position.width,
                        position.height,
                        1f,
                        1f,
                        position.angle,
                        0,
                        0,
                        visual.texture.width,
                        visual.texture.height,
                        position.flipX,
                        position.flipY
                )
            }
        }

        batch.end()
        renderQueue.clear()
    }

    override fun processEntity(entity: Entity?, deltaTime: Float) {
        entity?.let { renderQueue += it }
    }
}
