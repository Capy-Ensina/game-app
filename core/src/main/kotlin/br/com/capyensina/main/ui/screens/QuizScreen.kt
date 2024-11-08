package br.com.capyensina.main.ui.screens

import br.com.capyensina.main.Main
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

class QuizScreen (main: Main) : KtxScreen {

    private val batch = SpriteBatch()
    private val shapeRenderer = ShapeRenderer()
    private val font = BitmapFont()
    private val customFont = createCustomFont(60)

    val mainGame = main

    // Retângulos
    private val hudTopColor = ColorTheme.GREEN

    private val backgroundamarelo = Texture("backgroundamarelo.png".toInternalFile())

    //imagens da interface
    private val redquestion = Texture("redquestion.png".toInternalFile())
    private val blueaswerA = Texture("blueanswerA.png".toInternalFile())
    private val blueaswerB = Texture("blueanswerB.png".toInternalFile())
    private val blueaswerC = Texture("blueanswerC.png".toInternalFile())
    private val blueaswerD = Texture("blueanswerD.png".toInternalFile())


    override fun render(delta: Float) {
        input()
        logic()
        draw()

        customFont.color = Color.BLACK
        batch.use {
            customFont.draw(it, "QUIZ", 500f, 2750f)
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
        backgroundamarelo.disposeSafely()
        redquestion.disposeSafely()
        blueaswerA.disposeSafely()
        blueaswerB.disposeSafely()
        blueaswerC.disposeSafely()
        blueaswerD.disposeSafely()
    }

    private fun input() {
        checkButtonClick()
    }

    private fun logic() {

    }

    private fun draw() {

        batch.use {
            it.draw(
                backgroundamarelo, 0f, 0f, Gdx.graphics.width.toFloat(), Gdx.graphics.height.toFloat()
            )
        }

        shapeRenderer.use(ShapeRenderer.ShapeType.Filled) {
            it.color = ColorTheme.GREEN
            it.rect(0f, Gdx.graphics.height - 220f, Gdx.graphics.width.toFloat(), 300f)
        }

        batch.use {
            //questao um
            it.draw(redquestion, 120f, 2200f, 1100f, 400f)
            it.draw(blueaswerA, 160f, 1960f, 950f, 350f)
            it.draw(blueaswerB, 160f, 1700f, 930f, 350f)
            it.draw(blueaswerC, 160f, 1440f, 930f, 350f)
            it.draw(blueaswerD, 160f, 1240f, 950f, 300f)

            // questao dois
            it.draw(redquestion, 120f, 900f, 1100f, 400f)
            it.draw(blueaswerA, 160f, 660f, 950f, 350f)
            it.draw(blueaswerB, 160f, 400f, 930f, 350f)
            it.draw(blueaswerC, 160f, 140f, 930f, 350f)
            it.draw(blueaswerD, 160f, -65f, 950f, 300f)

        }
    }
}
