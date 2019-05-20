package com.jamdan2.flappybird.systems

import com.badlogic.ashley.core.ComponentMapper
import com.badlogic.ashley.core.Entity
import com.badlogic.ashley.core.Family
import com.badlogic.ashley.systems.IteratingSystem
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input.Keys
import com.jamdan2.flappybird.components.ControlComponent

class ControlSystem : IteratingSystem(Family.all(ControlComponent::class.java).get()) {
    private val controlMapper = ComponentMapper.getFor(ControlComponent::class.java)

    override fun processEntity(entity: Entity?, deltaTime: Float) {
        val control = controlMapper.get(entity)

        control.jump = Gdx.input.isKeyJustPressed(Keys.SPACE) || Gdx.input.justTouched()
    }
}
