package com.jamdan2.flappybird.screens

import com.badlogic.ashley.core.Engine
import com.badlogic.gdx.scenes.scene2d.Stage
import com.jamdan2.flappybird.Game
import com.jamdan2.flappybird.World
import com.jamdan2.flappybird.systems.*
import ktx.app.KtxScreen

class GameScreen(val game: Game) : KtxScreen {
    val stage = Stage()

    val engine = Engine()

    val world = World(engine)

    init {
        engine.apply {
            addSystem(RenderingSystem(game.batch))
            addSystem(DeltaSystem())
            addSystem(GravitySystem())
            addSystem(ControlSystem())
            addSystem(BirdSystem())
        }

        // Bird created for testing purposes
        world.createBird()
        world.createPipe()
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
