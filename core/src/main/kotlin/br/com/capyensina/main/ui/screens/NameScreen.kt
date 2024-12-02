package br.com.capyensina.main.ui.screens

import br.com.capyensina.main.Main
import br.com.capyensina.main.components.Clickable
import br.com.capyensina.main.util.AssetManager
import br.com.capyensina.main.util.ColorTheme
import br.com.capyensina.main.util.MySpriteBatch
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.utils.viewport.ExtendViewport
import ktx.app.KtxScreen
import ktx.assets.toInternalFile
import ktx.graphics.use

class NameScreen (mainGame: Main) : KtxScreen {
    private val main = mainGame

    private val batch = MySpriteBatch()
    private val customFontBold = AssetManager.getFontTextBold()
    private val customFont = AssetManager.getFont()

    private val camera = OrthographicCamera()
    private val viewport = ExtendViewport(main.WORLD_WIDTH, main.WORLD_HEIGHT, camera)

    //private val backgroundAmarelo = Texture("bg/backgroundamarelo.png".toInternalFile())

    //imagens da interface
    private val infoBoxUm = Clickable(
        Texture("text-box/infoboxum.png".toInternalFile()),
        Rectangle(15f, 1100f, 1350f, 1200f)
    ) { Gdx.input.getTextInput(main.textInputListener, "Digite seu nome", "", "Usuário") }

    private val stars = Texture("stars/estrela.png")
    private val skipButton = Clickable(
        Texture("button/skipbutton.png".toInternalFile()),
        Rectangle(650f, 170f, 900f, 900f)
    ) { main.setScreen<StoryScreen>() }

    init {
        camera.position.set(
            main.WORLD_WIDTH/2,
            main.WORLD_HEIGHT/2,
            0f
        )
        viewport.apply()
    }

    override fun render(delta: Float) {
        camera.update()
        batch.projectionMatrix = camera.combined

        input()
        logic()
        draw()
    }

    override fun resize(width: Int, height: Int) {
        viewport.update(width, height)
    }

    override fun dispose() {

    }

    private fun input() {
        if (Gdx.input.justTouched()) {
            // Transforma o click na tela em uma posição dentro do mundo
            val worldPos = viewport.unproject(Vector2(Gdx.input.x.toFloat(), Gdx.input.y.toFloat()))

            if (skipButton.collider.contains(worldPos)) skipButton.action()
            if (infoBoxUm.collider.contains(worldPos)) infoBoxUm.action()
        }
    }

    private fun logic() {

    }

    private fun draw() {
        Gdx.gl.glClearColor(
            ColorTheme.TEXT_BACKGROUND_COLOR.r,
            ColorTheme.TEXT_BACKGROUND_COLOR.g,
            ColorTheme.TEXT_BACKGROUND_COLOR.b,
            ColorTheme.TEXT_BACKGROUND_COLOR.a
        )
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        batch.use {
            it.draw(infoBoxUm)
            it.draw(skipButton)

            customFontBold.draw(it, "Digite seu nome :D", 330f, 1900f)
            customFont.draw(it, main.playerScoreManager.name, 300f, 1650f)
        }
    }
}
