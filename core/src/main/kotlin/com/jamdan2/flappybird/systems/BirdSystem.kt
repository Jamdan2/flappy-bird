package com.jamdan2.flappybird.systems

import com.badlogic.ashley.core.ComponentMapper
import com.badlogic.ashley.core.Entity
import com.badlogic.ashley.core.Family
import com.badlogic.ashley.systems.IteratingSystem
import com.jamdan2.flappybird.components.ControlComponent
import com.jamdan2.flappybird.components.DeltaComponent

class BirdSystem : IteratingSystem(Family.all(
        ControlComponent::class.java,
        DeltaComponent::class.java
).get()) {
    val controlMapper = ComponentMapper.getFor(ControlComponent::class.java)
    val deltaMapper = ComponentMapper.getFor(DeltaComponent::class.java)

    override fun processEntity(entity: Entity?, deltaTime: Float) {
        val control = controlMapper.get(entity)
        val delta = deltaMapper.get(entity)

        if (control.jump) delta.dy = 25f
    }
}
