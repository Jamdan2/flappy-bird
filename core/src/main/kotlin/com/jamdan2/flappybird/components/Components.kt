package com.jamdan2.flappybird.components

import com.badlogic.ashley.core.Component
import com.badlogic.gdx.graphics.Texture

sealed class VisualComponent : Component {
    abstract val center: Boolean
}

data class SimpleVisualComponent(
        val texture: Texture,
        override val center: Boolean = false,
        val stretchBottomOnly: Boolean = false
) : VisualComponent()

data class RayVisualComponent(
        val texture: Texture,
        override val center: Boolean
) : VisualComponent()

data class PositionComponent(
        var x: Float,
        var y: Float,
        val z: Float,
        val width: Float,
        val height: Float,
        var angle: Float = 0f,
        var flipX: Boolean = false,
        var flipY: Boolean = false
) : Component

data class DeltaComponent(
        var dx: Float,
        var dy: Float
) : Component

data class ControlComponent(
        var jump: Boolean
) : Component
