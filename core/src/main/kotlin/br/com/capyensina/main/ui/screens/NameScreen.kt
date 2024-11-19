package br.com.capyensina.main.ui.screens

import br.com.capyensina.main.Main
import br.com.capyensina.main.util.AssetManager
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import ktx.app.KtxScreen
import ktx.assets.toInternalFile
import ktx.graphics.use

class NameScreen (main: Main) : KtxScreen {
    private val batch = SpriteBatch()

    private val customFontBold = AssetManager.getFontTextBold()
    private val customFont = AssetManager.getFont()

    private val backgroundAmarelo = Texture("bg/backgroundamarelo.png".toInternalFile())

    //imagens da interface
    private val infoBoxUm = Texture("text-box/infoboxum.png".toInternalFile())
    private val continuarButton = Texture("button/continuarbutton.png".toInternalFile())
    private val stars = Texture("stars/estrela.png")
    private val skipButton = Texture("button/skipbutton.png".toInternalFile())


    override fun render(delta: Float) {
        input()
        logic()
        draw()

        batch.use {
            customFontBold.draw(it, "Digite seu nome :D", 330f, 1750f)
            customFont.draw(it, "_________________", 300f, 1500f)
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

            it.draw(infoBoxUm, 15f, 950f, 1350f, 1200f)
            it.draw(skipButton, 650f, 30f, 900f, 900f )
        }


    }
}
