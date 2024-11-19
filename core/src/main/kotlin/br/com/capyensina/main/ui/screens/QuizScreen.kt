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

class QuizScreen (main: Main) : KtxScreen {

    private val batch = SpriteBatch()
    private val shapeRenderer = ShapeRenderer()
    private val font = BitmapFont()
    //private val customFont = createCustomFont(60)
    private val customFont = AssetManager.getFont()
    private val customFontBold = AssetManager.getFontTextBold()
    private val customFontText = AssetManager.getFontText()

    val mainGame = main

    // Retângulos
    private val hudTopColor = ColorTheme.GREEN

    private val backgroundamarelo = Texture("bg/backgroundamarelo.png".toInternalFile())

    //imagens da interface
    private val redquestion = Texture("button/redquestion.png".toInternalFile())
    private val blueaswerA = Texture("button/blueanswerA.png".toInternalFile())
    private val blueaswerB = Texture("button/blueanswerB.png".toInternalFile())
    private val blueaswerC = Texture("button/blueanswerC.png".toInternalFile())
    private val blueaswerD = Texture("button/blueanswerD.png".toInternalFile())

    private val skipButton = Texture("button/skipbutton.png".toInternalFile())


    override fun render(delta: Float) {
        input()
        logic()
        draw()

        batch.use {
            customFont.draw(it, "QUIZ", 550f, 2750f)

        }

        // Questao 1
        batch.use {
            val text = "Por que educação financeira é importante?"

            val textWidth = 900f
            val x = 350f
            val y = 2120f

            layout.setText(customFontBold, text, Color.BLACK, textWidth, -1, true)

            customFontBold.draw(batch, layout, x, y)
        }

        // Resposta A
        batch.use {
            val text = "Porque capivaras gostam de dinheiro."

            val textWidth = 800f
            val x = 320f
            val y = 1780f

            layout.setText(customFontBold, text, Color.BLACK, textWidth, -1, true)

            customFontBold.draw(batch, layout, x, y)
        }

        // Resposta B
        batch.use {
            val text = "Para aprender gerir o próprio dinheiro."

            val textWidth = 800f
            val x = 320f
            val y = 1470f

            layout.setText(customFontBold, text, Color.BLACK, textWidth, -1, true)

            customFontBold.draw(batch, layout, x, y)
        }

        // Resposta C
        batch.use {
            val text = "Porque capivaras são capitalistas."

            val textWidth = 800f
            val x = 320f
            val y = 1150f

            layout.setText(customFontBold, text, Color.BLACK, textWidth, -1, true)

            customFontBold.draw(batch, layout, x, y)
        }

        // Resposta D
        batch.use {
            val text = "Por que apocapivaras está chegando."

            val textWidth = 800f
            val x = 320f
            val y = 840f

            layout.setText(customFontBold, text, Color.BLACK, textWidth, -1, true)

            customFontBold.draw(batch, layout, x, y)
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
        backgroundamarelo.disposeSafely()
        redquestion.disposeSafely()
        blueaswerA.disposeSafely()
        blueaswerB.disposeSafely()
        blueaswerC.disposeSafely()
        blueaswerD.disposeSafely()
        skipButton.disposeSafely()
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
            /*//questao um  -> posicoes antigas
            it.draw(redquestion, 120f, 2200f, 1100f, 400f)
            it.draw(blueaswerA, 160f, 1960f, 950f, 350f)
            it.draw(blueaswerB, 160f, 1700f, 930f, 350f)
            it.draw(blueaswerC, 160f, 1440f, 930f, 350f)
            it.draw(blueaswerD, 160f, 1240f, 950f, 300f)*/

            val deslocamentoY = -400f
            val deslocamentoX = -100f

            val aumento = 1.2f

            it.draw(redquestion, 120f + deslocamentoX, 2200f + deslocamentoY, 1100f * aumento, 400f * aumento)
            it.draw(blueaswerA, 160f + deslocamentoX, 1960f + deslocamentoY - (50f * aumento), 950f * aumento, 350f * aumento)
            it.draw(blueaswerB, 160f + deslocamentoX, 1700f + deslocamentoY - (100f * aumento), 930f * aumento, 350f * aumento)
            it.draw(blueaswerC, 160f + deslocamentoX, 1440f + deslocamentoY - (150f * aumento), 930f * aumento, 350f * aumento)
            it.draw(blueaswerD, 160f + deslocamentoX, 1240f + deslocamentoY - (200f * aumento), 950f * aumento, 300f * aumento)

            it.draw(skipButton, 650f, 30f, 900f, 900f ) // botao para passar a proxima pergunta

            /*// questao dois
            it.draw(redquestion, 120f, 900f, 1100f, 400f)
            it.draw(blueaswerA, 160f, 660f, 950f, 350f)
            it.draw(blueaswerB, 160f, 400f, 930f, 350f)
            it.draw(blueaswerC, 160f, 140f, 930f, 350f)
            it.draw(blueaswerD, 160f, -65f, 950f, 300f)*/

        }

    }
}
