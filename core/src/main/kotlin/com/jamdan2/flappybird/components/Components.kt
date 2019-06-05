package com.jamdan2.flappybird.components

import com.badlogic.ashley.core.Component
import com.badlogic.gdx.graphics.Texture

data class VisualComponent(
        val texture: Texture,
        val center: Boolean = false,
        val stretchBottomOnly: Boolean = false
) : Component

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
