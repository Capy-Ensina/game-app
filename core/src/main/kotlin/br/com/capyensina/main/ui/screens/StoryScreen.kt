package br.com.capyensina.main.ui.screens

import br.com.capyensina.main.Main
import br.com.capyensina.main.components.Clickable
import br.com.capyensina.main.util.AssetManager
import br.com.capyensina.main.util.ColorTheme
import br.com.capyensina.main.util.MySpriteBatch
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.utils.viewport.ExtendViewport
import ktx.app.KtxScreen
import ktx.assets.disposeSafely
import ktx.assets.toInternalFile
import ktx.graphics.use

class StoryScreen  (mainGame: Main) : KtxScreen {
    private val main = mainGame
    private val batch = MySpriteBatch()
    private val customFontBold = AssetManager.getFontTextBold()
    private val customFont = AssetManager.getFont()
    private val camera = OrthographicCamera()
    private val viewport = ExtendViewport(main.WORLD_WIDTH, main.WORLD_HEIGHT, camera)

    private val background = Clickable(
        AssetManager.yellowBg,
        Rectangle(-100f, 0f, main.WORLD_WIDTH+200f, main.WORLD_HEIGHT)
    )

    //imagens da interface
    private val infoBoxQuatro = Clickable(
        AssetManager.infoBoxBiggest,
        Rectangle(15f, 950f, 1350f, 1200f)
    ) { this.nextLoreBox() }
    private val skipButton = Clickable(
        AssetManager.skipButton,
        Rectangle(650f, 30f, 900f, 900f )
    ) { this.nextLoreBox() }

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
    }

    private fun input() {
        if (Gdx.input.justTouched()) {
            // Transforma o click na tela em uma posição dentro do mundo
            val worldPos = viewport.unproject(Vector2(Gdx.input.x.toFloat(), Gdx.input.y.toFloat()))

            if (infoBoxQuatro.collider.contains(worldPos)) infoBoxQuatro.action()
            if (skipButton.collider.contains(worldPos)) skipButton.action()
        }
    }

    private fun logic() {

    }

    private fun draw() {
        Gdx.gl.glClearColor(
            ColorTheme.BACKGROUND_COLOR.r,
            ColorTheme.BACKGROUND_COLOR.g,
            ColorTheme.BACKGROUND_COLOR.b,
            ColorTheme.BACKGROUND_COLOR.a
        )
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        batch.use {
            it.draw(background)

            it.draw(infoBoxQuatro)
            it.draw(skipButton)

            // TODO agrupar a criação da TextBox com o texto nela contido
            customFont.draw(it, "A história", 400f, 2050f)


            val text = "Violetta perdeu tudo e agora vive de aluguel. Ajude-a a organizar suas finanças para pagar as contas em dia, melhorar seu lar e ter mais qualidade de vida."

            val textWidth = 900f
            val x = 280f
            val y = 1920f

            layout.setText(customFontBold, text, Color.BLACK, textWidth, -1, true)

            customFontBold.draw(batch, layout, x, y)
        }
    }

    private fun nextLoreBox(){
        main.setScreen<HomeScreen>()
    }
}
