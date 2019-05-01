package com.jamdan2.flappybird

import com.jamdan2.flappybird.screens.GameScreen
import ktx.app.KtxGame
import ktx.app.KtxScreen

class Game : KtxGame<KtxScreen>() {
    override fun create() {
        addScreen(GameScreen(this))
        setScreen<GameScreen>()
    }
}
