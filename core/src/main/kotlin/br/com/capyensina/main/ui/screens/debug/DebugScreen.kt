package br.com.capyensina.main.ui.screens.debug

import br.com.capyensina.main.Main
import br.com.capyensina.main.components.TextBox
import br.com.capyensina.main.util.AssetManager
import br.com.capyensina.main.util.BoxSize
import br.com.capyensina.main.util.MySpriteBatch
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.PerspectiveCamera
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.utils.viewport.ExtendViewport
import com.badlogic.gdx.utils.viewport.FillViewport
import com.badlogic.gdx.utils.viewport.FitViewport
import com.badlogic.gdx.utils.viewport.ScreenViewport
import ktx.app.KtxScreen
import ktx.assets.toInternalFile
import ktx.graphics.use

class DebugScreen(main: Main) : KtxScreen {

    /* NOTA 17/11/2024 20:04 - Malcoln
     * Testas suas coisas aqui, para evitar deixar código desnecessário nas telas que já estão
     * prontas, e já fica o aviso TUDO aqui pode ser apagado a qualquer momento, então não deixe nada
     * relevante "salvo" nessa tela
     */

    private val batch = MySpriteBatch()
    private val shapeRenderer = ShapeRenderer()
    private val mainGame = main

    private val customFont = AssetManager.getFont()

    //private val camera = OrthographicCamera()
    private val viewport = FitViewport(main.WORLD_WIDTH, main.WORLD_HEIGHT)

    init {
        mainGame.textBoxManager.configTextBox.isActive = true
        viewport.camera.position.set(viewport.camera.viewportWidth/2,viewport.camera.viewportHeight/2,0f);
    }

    override fun render(delta: Float) {
        input()
        logic()
        draw()
    }

    fun input(){
        if (Gdx.input.justTouched()) {
            val x = Gdx.input.x.toFloat()
            val y = Gdx.graphics.height - Gdx.input.y.toFloat()
            mainGame.hudManager.logic(Vector2(x, y))
            mainGame.textBoxManager.input(Vector2(x, y))
        }
    }

    fun logic(){

    }

    fun draw(){
        //camera.update()
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        viewport.apply()
        batch.projectionMatrix = viewport.camera.combined

        batch.use {
            // 1. Background
            mainGame.hudManager.drawBackground(it)

            // 2. Content
            customFont.draw(it, "INTRODUÇÃO I", 370f, 1750f)

            // Deve-se desenhar os popups por ultimo
            mainGame.textBoxManager.configTextBox.draw(it)
        }

        // 3. HUD
        /*
        shapeRenderer.use(ShapeRenderer.ShapeType.Filled) {
            mainGame.hudManager.drawShape(it)
        }
        */
        batch.use {
            mainGame.hudManager.draw(batch)
        }

    }

}
