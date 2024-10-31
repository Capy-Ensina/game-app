package br.com.capyensina.main.ui.screens

import br.com.capyensina.main.Main
import br.com.capyensina.main.util.AssetManager
import br.com.capyensina.main.util.ColorTheme
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.Texture.TextureFilter.Linear
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.ScreenUtils
import ktx.app.KtxScreen
import ktx.assets.disposeSafely
import ktx.assets.toInternalFile
import ktx.graphics.use

class HomeScreen(main: Main) : KtxScreen {
    private val image = Texture("logo.png".toInternalFile(), true).apply { setFilter(Linear, Linear) }
    private val batch = SpriteBatch()

    val mainGame = main

    override fun render(delta: Float) {
        input()
        logic()
        draw()
    }

    override fun dispose() {
        image.disposeSafely()
        batch.disposeSafely()
    }

    private fun input(){

    }

    private fun logic(){

    }

    private fun draw(){
        ScreenUtils.clear(ColorTheme.YELLOW)

        batch.use {
            it.draw(AssetManager.logo, 100f, 160f)
            it.draw(AssetManager.btn_confirm, 720f, 160f)
        }
    }
}
