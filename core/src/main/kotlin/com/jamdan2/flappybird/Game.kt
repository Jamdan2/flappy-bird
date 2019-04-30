package com.jamdan2.flappybird

import com.jamdan2.flappybird.screens.GameScreen
import ktx.app.KtxGame
import ktx.app.KtxScreen

object Game : KtxGame<KtxScreen>() {
    const val WIDTH = 2400f
    const val HEIGHT = 1600f

    override fun create() {
        setScreen<GameScreen>()
    }
}
