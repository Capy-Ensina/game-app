package br.com.capyensina.main.ui.screens

import br.com.capyensina.main.Main
import br.com.capyensina.main.util.ColorTheme
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.Texture.TextureFilter.Linear
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.utils.ScreenUtils
import ktx.app.KtxScreen
import ktx.assets.disposeSafely
import ktx.assets.toInternalFile
import ktx.graphics.use

class TextScreen(main: Main) : KtxScreen {
    private val batch = SpriteBatch()
    private val shapeRenderer = ShapeRenderer()
    private val font = BitmapFont()
    private val customFont = createCustomFont(60)

    val mainGame = main

    // Retângulos
    private val hudTopColor = ColorTheme.ORANGE


    private val backgroundmarrom = Texture("backgroundmarrom.png".toInternalFile())

    private val finalizarbutton = Texture("finalizarbutton.png".toInternalFile())

    override fun render(delta: Float) {

        input()
        logic()
        draw()

        customFont.color = Color.BLACK
        batch.use {
            customFont.draw(it, "INTRODUÇÃO I", 370f, 2750f)
        }
    }

    fun createCustomFont(size: Int): BitmapFont {
        val fontGenerator = FreeTypeFontGenerator(Gdx.files.internal("PixelOperatorHB8.ttf"))
        val fontParameter = FreeTypeFontGenerator.FreeTypeFontParameter().apply {
            this.size = size
        }
        val customFont = fontGenerator.generateFont(fontParameter)
        fontGenerator.dispose()
        return customFont
    }

    private fun checkButtonClick() {
        if (Gdx.input.justTouched()) {
            val x = Gdx.input.x.toFloat()
            val y = Gdx.graphics.height - Gdx.input.y.toFloat()

        }
    }

    override fun dispose() {
        batch.disposeSafely()
        shapeRenderer.dispose()
        font.disposeSafely()
        customFont.disposeSafely()
        finalizarbutton.disposeSafely()
    }

    private fun input() {
        checkButtonClick()
    }

    private fun logic() {

    }

    private fun draw() {

        //ScreenUtils.clear(ColorTheme.BROWN)

        batch.use {
            it.draw(backgroundmarrom, 0f, 0f, Gdx.graphics.width.toFloat(), Gdx.graphics.height.toFloat())
        }

        shapeRenderer.use(ShapeRenderer.ShapeType.Filled) {
            it.color = ColorTheme.ORANGE
            it.rect(0f, Gdx.graphics.height - 220f, Gdx.graphics.width.toFloat(), 300f)
        }


        batch.use {
            it.draw(finalizarbutton, 320f, 70f, 700f, 400f)
        }
    }
}
