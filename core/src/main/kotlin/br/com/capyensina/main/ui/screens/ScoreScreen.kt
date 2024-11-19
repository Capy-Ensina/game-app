package br.com.capyensina.main.ui.screens

import br.com.capyensina.main.Main
import br.com.capyensina.main.util.AssetManager
import br.com.capyensina.main.util.ColorTheme
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import ktx.app.KtxScreen
import ktx.assets.disposeSafely
import ktx.assets.toInternalFile
import ktx.graphics.use

class ScoreScreen (main: Main) : KtxScreen {
    private val batch = SpriteBatch()
    private val shapeRenderer = ShapeRenderer()
    private val font = BitmapFont()
    //private val customFont = createCustomFont(60)
    private val customFont = AssetManager.getFont()


    val mainGame = main

    // Retângulos
    private val hudTopColor = ColorTheme.GREEN

    private val backgroundAmarelo = Texture("bg/backgroundamarelo.png".toInternalFile())

    //imagens da interface
    private val infoBoxTres = Texture("text-box/infoboxum.png".toInternalFile())
    private val continuarButton = Texture("button/continuarbutton.png".toInternalFile())
    private val stars = Texture("stars/estrela.png")

    override fun render(delta: Float) {
        input()
        logic()
        draw()

        //customFont.color = Color.BLACK
        batch.use {
            customFont.draw(it, "PONTUAÇÃO", 400f, 2750f)
            customFont.draw(it, "Parabéns!", 400f, 1880f)
        }
    }

   /* fun createCustomFont(size: Int): BitmapFont {
        val fontGenerator = FreeTypeFontGenerator(Gdx.files.internal("PixelOperatorHB8.ttf"))
        val fontParameter = FreeTypeFontGenerator.FreeTypeFontParameter().apply {
            this.size = size
        }
        val customFont = fontGenerator.generateFont(fontParameter)
        fontGenerator.dispose()
        return customFont
    }*/

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
        backgroundAmarelo.disposeSafely()
        infoBoxTres.disposeSafely()
        continuarButton.disposeSafely()
        stars.disposeSafely()

    }

    private fun input() {
        checkButtonClick()
    }

    private fun logic() {

    }

    private fun draw() {

        batch.use {
            it.draw(
                backgroundAmarelo, 0f, 0f, Gdx.graphics.width.toFloat(), Gdx.graphics.height.toFloat()
            )
        }

        shapeRenderer.use(ShapeRenderer.ShapeType.Filled) {
            it.color = ColorTheme.GREEN
            it.rect(0f, Gdx.graphics.height - 220f, Gdx.graphics.width.toFloat(), 300f)
        }

        batch.use {

            it.draw(infoBoxTres, 15f, 1050f, 1350f, 1200f)
            it.draw(continuarButton, 200f, 800f, 900f, 450f)

            // cordenada das estrelas caso precise sei lá
            it.draw(stars, 220f, 1550f, 200f, 200f) // Estrela 1
            it.draw(stars, 400f, 1550f, 200f, 200f) // Estrela 2
            it.draw(stars, 580f, 1550f, 200f, 200f) // Estrela 3
            it.draw(stars, 760f, 1550f, 200f, 200f) // Estrela 4
            it.draw(stars, 940f, 1550f, 200f, 200f) // Estrela 5

        }
    }
}
