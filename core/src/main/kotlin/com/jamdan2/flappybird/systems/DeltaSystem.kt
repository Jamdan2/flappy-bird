package com.jamdan2.flappybird.systems

import com.badlogic.ashley.core.ComponentMapper
import com.badlogic.ashley.core.Entity
import com.badlogic.ashley.core.Family
import com.badlogic.ashley.systems.IteratingSystem
import com.jamdan2.flappybird.components.DeltaComponent
import com.jamdan2.flappybird.components.PositionComponent

class DeltaSystem : IteratingSystem(Family.all(PositionComponent::class.java, DeltaComponent::class.java).get()) {
    val positionMapper = ComponentMapper.getFor(PositionComponent::class.java)
    val deltaMapper = ComponentMapper.getFor(DeltaComponent::class.java)

    override fun processEntity(entity: Entity?, deltaTime: Float) {
        val positionComponent = positionMapper.get(entity)
        val deltaComponent = deltaMapper.get(entity)

        positionComponent.x += deltaComponent.dx
        positionComponent.y += deltaComponent.dy
    }
}
