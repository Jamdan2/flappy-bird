package com.jamdan2.flappybird

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.jamdan2.flappybird.screens.GameScreen
import ktx.app.KtxGame
import ktx.app.KtxScreen

class Game : KtxGame<KtxScreen>() {
    lateinit var batch: SpriteBatch

    override fun create() {
        batch = SpriteBatch()
        addScreen(GameScreen(this))
        setScreen<GameScreen>()
    }

    override fun render() {
        val gl = Gdx.gl
        gl.glClearColor(1f, 1f, 1f, 0f)
        gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        super.render()
    }
}
