package br.com.capyensina.main.ui.screens

import br.com.capyensina.main.Main
import br.com.capyensina.main.components.Clickable
import br.com.capyensina.main.components.dispose
import br.com.capyensina.main.components.disposeSafely
import br.com.capyensina.main.ui.layout.HomeLayout
import br.com.capyensina.main.util.AssetManager
import br.com.capyensina.main.util.ColorTheme
import br.com.capyensina.main.util.MySpriteBatch
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.Texture.TextureFilter.Linear
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import ktx.app.KtxScreen
import ktx.assets.disposeSafely
import ktx.assets.toInternalFile
import ktx.graphics.use
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.scenes.scene2d.Stage
import ktx.actors.stage
import ktx.assets.Asset


class HomeScreen(main: Main) : KtxScreen {
    private val batch = MySpriteBatch()
    private val shapeRenderer = ShapeRenderer()
    private val background = AssetManager.mainBg

    val mainGame = main

    //hud retangulos
    private val hudTopColor = ColorTheme.BLUE
    private val hudBottomColor = ColorTheme.BLUE

    /*
    private val hudHeight = 50f
    private val screenWidth = 800f*/

    override fun render(delta: Float) {
        //ScreenUtils.clear(0f, 0f, 0f, 1f)
        input()
        logic()
        draw()
    }

    private fun checkButtonClick() {
        if (Gdx.input.justTouched()) {
            val x = Gdx.input.x.toFloat()
            val y = Gdx.graphics.height - Gdx.input.y.toFloat()
            val clickPos = Vector2(x, y)

            mainGame.hudManager.logic(clickPos)
        }
    }

    override fun dispose() {
        batch.disposeSafely()
        shapeRenderer.disposeSafely()
    }

    private fun input(){
        checkButtonClick()
    }

    private fun logic(){

    }

    private fun draw(){
        //ScreenUtils.clear(ColorTheme.YELLOW)
        val screenWidth = Gdx.graphics.width.toFloat()
        val screenHeight = Gdx.graphics.height.toFloat()

        batch.use {
            //it.draw(background, 0f, 0f, Gdx.graphics.width.toFloat(), Gdx.graphics.height.toFloat())
        }

        shapeRenderer.use(ShapeRenderer.ShapeType.Filled) {
            // Retângulo superior
            it.color = ColorTheme.BLUE
            it.rect(0f, Gdx.graphics.height - 220f, Gdx.graphics.width.toFloat(), 300f)

            // Retângulo inferior
            it.color = ColorTheme.BLUE
            it.rect(0f, 0f, Gdx.graphics.width.toFloat(), 300f)
        }

        batch.use {
            mainGame.hudManager.draw(it)
        }
    }
}
