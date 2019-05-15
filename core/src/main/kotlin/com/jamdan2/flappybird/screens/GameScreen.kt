package com.jamdan2.flappybird.screens

import com.badlogic.ashley.core.Engine
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.scenes.scene2d.Stage
import com.jamdan2.flappybird.Game
import com.jamdan2.flappybird.World
import com.jamdan2.flappybird.components.SpriteComponent
import com.jamdan2.flappybird.systems.RenderingSystem
import ktx.app.KtxScreen
import ktx.ashley.entity

class GameScreen(val game: Game) : KtxScreen {
    val stage = Stage()

    val engine = Engine()

    val world = World(engine)

    init {
        engine.apply {
            addSystem(RenderingSystem(game.batch))
        }
        engine.entity {
            entity.apply {
                add(SpriteComponent(Sprite(Texture("bird.png"))))
            }
        }

        // Bird created for testing purposes
        world.createBird()
    }

    private fun update(delta: Float) {
        engine.update(delta)
    }

    override fun render(delta: Float) {
        update(delta)
        stage.act(delta)
        stage.draw()
    }
}
