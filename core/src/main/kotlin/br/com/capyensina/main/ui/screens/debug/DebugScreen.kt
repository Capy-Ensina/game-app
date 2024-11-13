package br.com.capyensina.main.ui.screens.debug

import br.com.capyensina.main.Main
import br.com.capyensina.main.util.MySpriteBatch
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.math.Vector2
import ktx.app.KtxScreen
import ktx.assets.toInternalFile
import ktx.graphics.use

class DebugScreen(main: Main) : KtxScreen {
    private val batch = MySpriteBatch()
    private val shapeRenderer = ShapeRenderer()
    private val mainGame = main

    override fun render(delta: Float) {
        input()
        logic()
        draw()
    }

    fun input(){
        if (Gdx.input.justTouched()) {
            val x = Gdx.input.x.toFloat()
            val y = Gdx.graphics.height - Gdx.input.y.toFloat()
            mainGame.hudManager.logic(Vector2(x, y))
        }
    }

    fun logic(){

    }

    fun draw(){
        batch.use {
            mainGame.hudManager.drawBackground(it)
        }

        shapeRenderer.use(ShapeRenderer.ShapeType.Filled) {
            mainGame.hudManager.drawShape(it)
        }

        batch.use {
            mainGame.hudManager.draw(batch)
        }
    }

}
