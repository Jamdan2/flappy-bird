package com.jamdan2.flappybird

import com.jamdan2.flappybird.screens.GameScreen
import ktx.app.KtxGame
import ktx.app.KtxScreen

class Game : KtxGame<KtxScreen>() {
    val width = 2400f
    val height = 1600f

    override fun create() {
        addScreen(GameScreen(this))
        setScreen<GameScreen>()
    }
}
