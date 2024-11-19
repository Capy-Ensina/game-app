package br.com.capyensina.main.ui.screens

import br.com.capyensina.main.Main
import br.com.capyensina.main.util.AssetManager
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import ktx.app.KtxScreen
import ktx.assets.toInternalFile
import ktx.graphics.use

class StoryScreen  (main: Main) : KtxScreen {
    private val batch = SpriteBatch()

    private val customFontBold = AssetManager.getFontTextBold()
    private val customFont = AssetManager.getFont()

    private val backgroundAmarelo = Texture("bg/backgroundamarelo.png".toInternalFile())

    //imagens da interface
    private val infoBoxQuatro = Texture("text-box/infoboxquatro.png".toInternalFile())
    private val continuarButton = Texture("button/continuarbutton.png".toInternalFile())
    private val stars = Texture("stars/estrela.png")
    private val skipButton = Texture("button/skipbutton.png".toInternalFile())


    override fun render(delta: Float) {
        input()
        logic()
        draw()

        batch.use {
            customFont.draw(it, "A história", 400f, 2050f)
        }

        batch.use {
            val text = "Violetta perdeu tudo e agora vive de aluguel. Ajude-a a organizar suas finanças para pagar as contas em dia, melhorar seu lar e ter mais qualidade de vida."

            val textWidth = 900f
            val x = 280f
            val y = 1920f

            layout.setText(customFontBold, text, Color.BLACK, textWidth, -1, true)

            customFontBold.draw(batch, layout, x, y)
        }


    }

    private fun checkButtonClick() {
        if (Gdx.input.justTouched()) {
            val x = Gdx.input.x.toFloat()
            val y = Gdx.graphics.height - Gdx.input.y.toFloat()

        }
    }

    override fun dispose() {

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

        batch.use {

            it.draw(infoBoxQuatro, 15f, 950f, 1350f, 1200f)
            it.draw(skipButton, 650f, 30f, 900f, 900f )
        }


    }
}
