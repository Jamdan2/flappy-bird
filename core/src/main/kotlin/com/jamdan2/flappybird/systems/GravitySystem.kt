package com.jamdan2.flappybird.systems

import com.badlogic.ashley.core.ComponentMapper
import com.badlogic.ashley.core.Entity
import com.badlogic.ashley.core.Family
import com.badlogic.ashley.systems.IteratingSystem
import com.jamdan2.flappybird.components.DeltaComponent

class GravitySystem : IteratingSystem(Family.all(DeltaComponent::class.java).get()) {
    private val gravity = 2f

    val deltaMapper = ComponentMapper.getFor(DeltaComponent::class.java)

    override fun processEntity(entity: Entity?, deltaTime: Float) {
        deltaMapper.get(entity).dy -= gravity
    }
}
