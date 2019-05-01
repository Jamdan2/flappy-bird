package com.jamdan2.flappybird.screens

import com.badlogic.gdx.graphics.OrthographicCamera
import com.jamdan2.flappybird.Game
import ktx.app.KtxScreen

class GameScreen(val game: Game) : KtxScreen {
    val camera = OrthographicCamera().apply {
        setToOrtho(false, game.width, game.height)
    }
}
