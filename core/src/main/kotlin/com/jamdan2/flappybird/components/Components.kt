package com.jamdan2.flappybird.components

import com.badlogic.ashley.core.Component
import com.badlogic.gdx.graphics.g2d.Sprite

data class SpriteComponent(val sprite: Sprite): Component

data class PositionComponent(val x: Float, val y: Float): Component
