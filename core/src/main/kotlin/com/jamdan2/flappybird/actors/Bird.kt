package com.jamdan2.flappybird.actors

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.scenes.scene2d.Actor

class Bird : Actor() {
    val sprite = Sprite(Texture("bird.png"))

    override fun act(delta: Float) {
        sprite.setPosition(x++, y++)
    }

    override fun draw(batch: Batch?, parentAlpha: Float) {
        sprite.draw(batch)
    }
}
