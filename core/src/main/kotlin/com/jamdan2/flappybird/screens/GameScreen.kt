package com.jamdan2.flappybird.screens

import com.badlogic.gdx.scenes.scene2d.Stage
import com.jamdan2.flappybird.Game
import ktx.app.KtxScreen

class GameScreen(val game: Game) : KtxScreen {
    val stage = Stage()

    override fun render(delta: Float) {
        stage.act(delta)
        stage.draw()
    }
}
