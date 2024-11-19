package br.com.capyensina.main.ui.screens

import br.com.capyensina.main.Main
import br.com.capyensina.main.util.AssetManager
import br.com.capyensina.main.util.ColorTheme
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import ktx.app.KtxScreen
import ktx.assets.disposeSafely
import ktx.assets.toInternalFile
import ktx.graphics.use
import com.badlogic.gdx.graphics.g2d.GlyphLayout

val layout = GlyphLayout() // trem dos textos longos com quebra de linha

class TextScreen(main: Main) : KtxScreen {
    private val batch = SpriteBatch()
    private val shapeRenderer = ShapeRenderer()
    private val font = BitmapFont()
    //private val customFont = createCustomFont(60)
    private val customFont = AssetManager.getFont()
    private val customFontBold = AssetManager.getFontTextBold()
    private val customFontText = AssetManager.getFontText()

    val mainGame = main

    // Retângulos
    private val hudTopColor = ColorTheme.ORANGE


    private val backgroundmarrom = Texture("bg/backgroundamarelo.png".toInternalFile())

    private val finalizarbutton = Texture("button/finalizarbutton.png".toInternalFile())

    override fun render(delta: Float) {

        input()
        logic()
        draw()

        batch.use {
            customFont.draw(it, "INTRODUÇÃO I", 330f, 2750f)
            customFontBold.draw(it, "Capivaras do Tesouro", 300f, 2500f)

        }
        // para textos grandes
        batch.use {
            val text = "A educação financeira é essencial para o desenvolvimento de habilidades que permitem gerenciar recursos de forma consciente e eficiente. Ela envolve a compreensão de conceitos fundamentais, como planejamento financeiro, controle de gastos, investimentos, e a importância de poupar para o futuro. Ao adquirir conhecimentos sobre como lidar com o dinheiro, as pessoas podem tomar decisões mais informadas, evitando dívidas excessivas e aproveitando melhor suas oportunidades econômicas."

            val textWidth = 1200f
            val x = 60f
            val y = 2320f

            layout.setText(customFontText, text, Color.BLACK, textWidth, -1, true)

            customFontText.draw(batch, layout, x, y)
        }
    }

    /*fun createCustomFont(size: Int): BitmapFont {
        val fontGenerator = FreeTypeFontGenerator(Gdx.files.internal("PixelOperatorHB8.ttf"))
        val fontParameter = FreeTypeFontGenerator.FreeTypeFontParameter().apply {
            this.size = size
        }
        val customFont = fontGenerator.generateFont(fontParameter)
        fontGenerator.dispose()
        return customFont
    }*/


    override fun dispose() {
        batch.disposeSafely()
        shapeRenderer.dispose()
        font.disposeSafely()
        customFont.disposeSafely()
        finalizarbutton.disposeSafely()
        backgroundmarrom.disposeSafely()
    }

    private fun input() {
        checkButtonClick()

    }
    private fun checkButtonClick() {
        if (Gdx.input.justTouched()) {
            val x = Gdx.input.x.toFloat()
            val y = Gdx.graphics.height - Gdx.input.y.toFloat()

            //finalizar botao cordenadas
            if (x in 320f..(320f + 700f) && y in 70f..(70f + 400f)) {
                mainGame.setScreen<QuizScreen>()
            }

        }
    }

    private fun logic() {


    }

    private fun draw() {

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
