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

class SplashScreen (main: Main) : KtxScreen {
    private val batch = SpriteBatch()
    private val shapeRenderer = ShapeRenderer()
    private val font = BitmapFont()
    //private val customFont = createCustomFont(60)
    private val customFont = AssetManager.getFont()

    val mainGame = main

    private val carregandoscreen = Texture("bg/carregandoscreen.png".toInternalFile())
    private val capicoin = Texture("capicoin.png".toInternalFile())
    private val loadingum = Texture("loadingum.png".toInternalFile())
    private val startbutton = Texture("button/startbutton.png".toInternalFile())

    override fun render(delta: Float) {
        input()
        logic()
        draw()


        batch.use {
            customFont.draw(it, "CARREGANDO...", 300f, 980f)
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
        carregandoscreen.disposeSafely()
        loadingum.disposeSafely()
        capicoin.disposeSafely()
        startbutton.disposeSafely()
    }

    private fun input() {

    }

    private fun logic() {

    }

    private fun draw() {

        batch.use {
            it.draw(carregandoscreen, 0f, 0f, Gdx.graphics.width.toFloat(), Gdx.graphics.height.toFloat())

            it.draw(loadingum, 200f, 920f, 900f, 400f)
            it.draw(capicoin, 300f, 1200f, 700f, 700f)

            //it.draw(startbutton, 160f, 800f, 1000f, 1000f) botao de start
        }

    }
}
