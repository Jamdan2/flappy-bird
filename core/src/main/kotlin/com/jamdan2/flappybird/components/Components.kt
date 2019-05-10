package com.jamdan2.flappybird.components

import com.badlogic.ashley.core.Component
import com.badlogic.gdx.graphics.g2d.Sprite

data class SpriteComponent(val sprite: Sprite): Component

data class BehaviorComponent(val behavior: Behavior): Component {
    enum class Behavior {
        STATIC, DYNAMIC
    }
}

data class LifeComponent(val isAlive: Boolean): Component

data class PositionComponent(val x: Float, val y: Float): Component
