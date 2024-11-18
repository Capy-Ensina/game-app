package br.com.capyensina.main.ui.screens.debug

import br.com.capyensina.main.Main
import br.com.capyensina.main.util.AssetManager
import br.com.capyensina.main.util.ColorTheme
import br.com.capyensina.main.util.MySpriteBatch
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.utils.viewport.ExtendViewport
import ktx.app.KtxScreen
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

    private val camera = OrthographicCamera()
    private val viewport = ExtendViewport(main.WORLD_WIDTH, main.WORLD_HEIGHT, camera)

    init {
        camera.position.set(
            mainGame.WORLD_WIDTH/2,
            mainGame.WORLD_HEIGHT/2,
            0f
        )
        viewport.apply()
        resize(Gdx.graphics.width, Gdx.graphics.height)
    }

    override fun render(delta: Float) {
        camera.update()
        batch.projectionMatrix = camera.combined
        shapeRenderer.projectionMatrix = camera.combined

        input()
        logic()
        draw()
    }

    override fun resize(width: Int, height: Int) {
        viewport.update(width, height);
    }

    fun input(){
        if (Gdx.input.justTouched()) {
            // Transforma o click na tela em uma posição dentro do mundo
            val worldPos = viewport.unproject(Vector2(Gdx.input.x.toFloat(), Gdx.input.y.toFloat()))

            // Verifica cliquesna Hud
            mainGame.hudManager.input(worldPos)

            // Verifica cliques nos popups
            mainGame.textBoxManager.input(worldPos)
        }
    }

    fun logic(){

    }

    fun draw(){

        Gdx.gl.glClearColor(
            ColorTheme.BACKGROUND_COLOR.r,
            ColorTheme.BACKGROUND_COLOR.g,
            ColorTheme.BACKGROUND_COLOR.b,
            ColorTheme.BACKGROUND_COLOR.a
        )
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        batch.use {
            // 1. Background
            mainGame.hudManager.drawDebugBackground(it)

            // 2. Content
            customFont.draw(it, "INTRODUÇÃO I", mainGame.WORLD_WIDTH/2, mainGame.WORLD_HEIGHT)

            // Deve-se desenhar os popups por ultimo
            mainGame.textBoxManager.draw(it)
        }

        // 3. HUD
        shapeRenderer.use(ShapeRenderer.ShapeType.Filled) {
            mainGame.hudManager.drawDebugShape(it)
        }

        batch.use {
            mainGame.hudManager.draw(it)
        }
    }

}
