package br.com.capyensina.main.ui.screens

import br.com.capyensina.main.Main
import br.com.capyensina.main.components.Clickable
import br.com.capyensina.main.components.disposeSafely
import br.com.capyensina.main.util.AssetManager
import br.com.capyensina.main.util.ColorTheme
import br.com.capyensina.main.util.MySpriteBatch
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Animation
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.utils.viewport.ExtendViewport
import ktx.app.KtxScreen
import ktx.assets.toInternalFile
import ktx.graphics.use

class ByeScreen (var main: Main) : KtxScreen {
    private val batch = MySpriteBatch()
    private val customFont = AssetManager.getFont()
    private val camera = OrthographicCamera()
    private val viewport = ExtendViewport(main.WORLD_WIDTH, main.WORLD_HEIGHT, camera)

    // frames da animacao
    private val loadingOne = Texture("loadingframes/loadingone.png".toInternalFile())
    private val loadingTwo = Texture("loadingframes/loadingtwo.png".toInternalFile())
    private val loadingThree = Texture("loadingframes/loadingthree.png".toInternalFile())
    private val loadingFour = Texture("loadingframes/loadingfour.png".toInternalFile())

    private val loadingAnimation = Animation<TextureRegion>(
        0.5f, // Duração de cada frame (em segundos)
        TextureRegion(loadingOne),
        TextureRegion(loadingTwo),
        TextureRegion(loadingThree),
        TextureRegion(loadingFour)
    ).apply {
        playMode = Animation.PlayMode.LOOP // A animação irá repetir
    }

    private var stateTime = 0f // Tempo acumulado para a animação


    // Botões
    private val startButton = Clickable(
        AssetManager.startButton,
        Rectangle(160f, 800f, 1000f, 1000f)
    ) {
        main.setScreen<NameScreen>()
    }

    // Imagens
    private val loadingBackground = Clickable(
        AssetManager.loadBg,
        Rectangle(0f, 0f, main.WORLD_WIDTH, main.WORLD_HEIGHT)
    )
    private val capicoin = Clickable(
        AssetManager.capicoinIcon,
        Rectangle(300f, 1200f, 700f, 700f)
    )

    private var isLoading = true

    init {
        camera.position.set(
            main.WORLD_WIDTH/2,
            main.WORLD_HEIGHT/2,
            0f
        )
        viewport.apply()
    }

    override fun show() {
        main.audioManager.startMusic()
    }

    override fun render(delta: Float) {
        camera.update()
        batch.projectionMatrix = camera.combined

        stateTime += delta // Atualizar o tempo da animação

        input()
        logic()
        draw()
    }

    override fun resize(width: Int, height: Int) {
        viewport.update(width, height)
    }

    override fun dispose() {
        //loadingBar.disposeSafely()
        capicoin.disposeSafely()
        startButton.disposeSafely()
    }

    private fun input() {
        if (Gdx.input.justTouched()) {
            // Transforma o click na tela em uma posição dentro do mundo
            val worldPos = viewport.unproject(Vector2(Gdx.input.x.toFloat(), Gdx.input.y.toFloat()))

            // Tocar na tela para "terminar de carregar"
            if (isLoading) {
                isLoading = false
            } else {
                if (startButton.collider.contains(worldPos)) startButton.action()
            }
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
            it.draw(loadingBackground)

            it.draw(capicoin)


            customFont.draw(it, "OBRIGADO POR JOGAR!", 70f, 900f)
        }
    }
}
