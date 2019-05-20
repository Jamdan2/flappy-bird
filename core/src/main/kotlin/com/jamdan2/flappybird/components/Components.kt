package com.jamdan2.flappybird.components

import com.badlogic.ashley.core.Component
import com.badlogic.gdx.graphics.g2d.Sprite

sealed class EntityComponents : Component {
    @Suppress("CanSealedSubClassBeObject") // Needs to be class for use in systems
    class BirdComponent : EntityComponents()
}

data class SpriteComponent(val sprite: Sprite) : Component

data class PositionComponent(
        var x: Float,
        var y: Float,
        val z: Float,
        val width: Float,
        val height: Float
) : Component

data class DeltaComponent(
        var dx: Float,
        var dy: Float
) : Component

data class ControlComponent(
        var jump: Boolean
) : Component
