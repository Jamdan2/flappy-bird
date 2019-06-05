package com.jamdan2.flappybird.systems

import com.badlogic.ashley.core.Component
import com.badlogic.ashley.core.ComponentMapper
import com.badlogic.ashley.core.Entity
import com.badlogic.ashley.core.Family
import com.badlogic.ashley.systems.IteratingSystem
import com.badlogic.gdx.Gdx
import com.jamdan2.flappybird.World
import com.jamdan2.flappybird.components.ControlComponent
import com.jamdan2.flappybird.components.PositionComponent
import kotlin.random.Random

class PipeGenerationSystem(val world: World) : IteratingSystem(Family.all(ControlComponent::class.java, PositionComponent::class.java).get()) {
    val positionMapper = ComponentMapper.getFor(PositionComponent::class.java)

    private var nextPipePosition = world.firstPipe

    override fun processEntity(entity: Entity?, deltaTime: Float) {
        val position = positionMapper[entity]

        while (nextPipePosition < position.x + (Gdx.graphics.width / 2)) {
            val gatePos = Random.nextInt(
                    world.minimumGateBottom.toInt(),
                    (world.maximumGateTop - world.gateSize).toInt()
            ).toFloat()
            world.createPipeGate(nextPipePosition, gatePos, gatePos + world.gateSize)
            nextPipePosition += world.pipeSpacer
        }
    }
}
