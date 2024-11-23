package br.com.capyensina.main.ui.screens

import br.com.capyensina.main.Main
import br.com.capyensina.main.components.Clickable
import br.com.capyensina.main.components.disposeSafely
import br.com.capyensina.main.util.AssetManager
import br.com.capyensina.main.util.ColorTheme
import br.com.capyensina.main.util.MySpriteBatch
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.utils.viewport.ExtendViewport
import ktx.app.KtxScreen
import ktx.assets.disposeSafely
import ktx.assets.toInternalFile
import ktx.graphics.use

class ScoreScreen (mainGame: Main) : KtxScreen {
    val main = mainGame

    private val batch = MySpriteBatch()
    private val font = BitmapFont()
    private val customFont = AssetManager.getFont()

    private val camera = OrthographicCamera()
    private val viewport = ExtendViewport(main.WORLD_WIDTH, main.WORLD_HEIGHT, camera)

    // Retângulos
    private val hudTopColor = ColorTheme.GREEN
    private val backgroundAmarelo = Texture("bg/backgroundamarelo.png".toInternalFile())

    //imagens da interface
    private val infoBoxTres = Clickable(
        Texture("text-box/infoboxum.png".toInternalFile()),
        Rectangle(15f, 1200f, 1350f, 1200f)
    )
    private val continuarButton = Clickable(
        Texture("button/continuarbutton.png".toInternalFile()),
        Rectangle(200f, 950f, 900f, 450f)
    ) { main.setScreen<HomeScreen>() }

    private val stars = Texture("stars/estrela.png")

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
        batch.disposeSafely()
        font.disposeSafely()
        customFont.disposeSafely()
        backgroundAmarelo.disposeSafely()
        infoBoxTres.disposeSafely()
        continuarButton.disposeSafely()
        stars.disposeSafely()
    }

    private fun input() {
        if (Gdx.input.justTouched()) {
            // Transforma o click na tela em uma posição dentro do mundo
            val worldPos = viewport.unproject(Vector2(Gdx.input.x.toFloat(), Gdx.input.y.toFloat()))

            if (continuarButton.collider.contains(worldPos)) continuarButton.action()
        }
    }

    private fun logic() { }

    private fun draw() {
        Gdx.gl.glClearColor(
            ColorTheme.TEXT_BACKGROUND_COLOR.r,
            ColorTheme.TEXT_BACKGROUND_COLOR.g,
            ColorTheme.TEXT_BACKGROUND_COLOR.b,
            ColorTheme.TEXT_BACKGROUND_COLOR.a
        )
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        batch.use {
            main.hudManager.drawTextScreen(it, hudTopColor)

            it.draw(infoBoxTres)
            it.draw(continuarButton)

            // cordenada das estrelas caso precise sei lá
            it.draw(stars, 220f, 1700f, 200f, 200f) // Estrela 1
            it.draw(stars, 400f, 1700f, 200f, 200f) // Estrela 2
            it.draw(stars, 580f, 1700f, 200f, 200f) // Estrela 3
            it.draw(stars, 760f, 1700f, 200f, 200f) // Estrela 4
            it.draw(stars, 940f, 1700f, 200f, 200f) // Estrela 5

            customFont.draw(it, "PONTUAÇÃO", 400f, 2900f)
            customFont.draw(it, "Parabéns!", 400f, 2030f)
        }
    }
}
