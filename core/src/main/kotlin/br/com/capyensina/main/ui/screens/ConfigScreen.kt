package br.com.capyensina.main.ui.screens

import br.com.capyensina.main.Main
import br.com.capyensina.main.components.Clickable
import br.com.capyensina.main.components.disposeSafely
import br.com.capyensina.main.util.AssetManager
import br.com.capyensina.main.util.MySpriteBatch
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.math.Vector2
import ktx.app.KtxScreen
import ktx.assets.disposeSafely
import ktx.graphics.use

class ConfigScreen (main: Main) : KtxScreen {
    private val batch = MySpriteBatch()
    private val shapeRenderer = ShapeRenderer()
    private val mainGame = main

    //imagens para a interface
    private val infoBox = Clickable (
        AssetManager.infoBoxBiggest,
        Rectangle(5f, 700f, 1350f, 1700f)
    )
    private val closeButton = Clickable (
        AssetManager.closeButton,
        Rectangle(1000f, 2120f, 400f, 400f)
    )

    override fun render(delta: Float) {
        input()
        logic()
        draw()
    }

    override fun dispose() {
        batch.disposeSafely()
        shapeRenderer.disposeSafely()

        infoBox.disposeSafely()
        closeButton.disposeSafely()
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

            it.draw(infoBox)
            it.draw(closeButton)
        }
    }

}
