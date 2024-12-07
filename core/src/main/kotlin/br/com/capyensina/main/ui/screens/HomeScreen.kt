package br.com.capyensina.main.ui.screens

import br.com.capyensina.main.Main
import br.com.capyensina.main.components.Clickable
import br.com.capyensina.main.util.AssetManager
import br.com.capyensina.main.util.ColorTheme
import br.com.capyensina.main.util.MySpriteBatch
import ktx.app.KtxScreen
import ktx.assets.disposeSafely
import ktx.graphics.use
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.utils.viewport.ExtendViewport
import ktx.assets.toInternalFile
import com.badlogic.gdx.graphics.g2d.Animation
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.utils.ScreenUtils


class HomeScreen(mainGame: Main) : KtxScreen {
    private val batch = MySpriteBatch()
    private val main = mainGame
    private val customFont = AssetManager.getFontTextBold()

    private val camera = OrthographicCamera()
    private val viewport = ExtendViewport(main.WORLD_WIDTH, main.WORLD_HEIGHT, camera)


    private val bookShelf = Clickable(
        AssetManager.bookShelf,
        Rectangle(505f, 1000f, 1000f, 1000f)
    )

    private val desk = Clickable(
        AssetManager.desk,
        Rectangle(730f, 300f, 600f, 600f)
    )

    private val computer = Clickable(
        AssetManager.computer,
        Rectangle(600f, 325f, 1200f, 1200f)
    )

    // Animação do personagem
    private val violetFrameOne = Texture("characters/framesviolettaidle/violettaframesum.png".toInternalFile())
    private val violetFrameTwo = Texture("characters/framesviolettaidle/violettaframesdois.png".toInternalFile())

    private val violetAnimation = Animation<TextureRegion>(
        0.5f, // Duração de cada frame (em segundos)
        TextureRegion(violetFrameOne),
        TextureRegion(violetFrameTwo)
    ).apply {
        playMode = Animation.PlayMode.LOOP // A animação irá repetir
    }

    private var stateTime = 0f // Tempo acumulado para a animação



    /* A camera precisa ser posicionada de modo que a tela inteira seja visivel, ou seja,
     * no meio da viewport
     */
    init {
        camera.position.set(
            main.WORLD_WIDTH/2,
            main.WORLD_HEIGHT/2,
            0f
        )
        viewport.apply()
    }

    override fun render(delta: Float) {
        main.audioManager.startMusic()
        // Atualiza os valores da câmera, e manda o batch e o shapeRenderer usarem ela
        camera.update()
        batch.projectionMatrix = camera.combined

        stateTime += delta // Atualizar o tempo da animação

        input()
        logic()
        draw()
    }

    // Sempre que "mudar de tamanho" a viewport PRECISA ser atualizada
    override fun resize(width: Int, height: Int) {
        viewport.update(width, height)
    }

    override fun dispose() {
        batch.disposeSafely()
        violetFrameOne.dispose()
        violetFrameTwo.dispose()
    }

    private fun input(){
        if (Gdx.input.justTouched()) {
            // Transforma o click na tela em uma posição dentro do mundo
            val worldPos = viewport.unproject(Vector2(Gdx.input.x.toFloat(), Gdx.input.y.toFloat()))

            // Verifica cliques na Hud
            main.hudManager.input(worldPos)



            // Verifica cliques nos popups
            main.textBoxManager.input(worldPos)
        }
    }

    private fun logic(){

    }

    private fun draw(){
        // Limpa a tela com a cor definida como BACKGROUND_COLOR
        Gdx.gl.glClearColor(
            ColorTheme.BACKGROUND_COLOR.r,
            ColorTheme.BACKGROUND_COLOR.g,
            ColorTheme.BACKGROUND_COLOR.b,
            ColorTheme.BACKGROUND_COLOR.a
        )
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        // Desenhar background e conteúdo na tela
        batch.use {
            // Background - deve ser desenhado primeiro
            main.hudManager.drawBackground(it)

            // Conteúdo da página aqui
            //it.draw(mainCharacterAnim.getKeyFrame(main.animationManager.elapsed), 20.0f, 20.0f)

            it.draw(bookShelf)
            it.draw(desk)
            it.draw(computer)

            val currentFrame = violetAnimation.getKeyFrame(stateTime)
            it.draw(currentFrame, 80f, 500f, 900f, 900f)

            // PopUP - deve ser desenhado por último, mas antes da HUD
            main.textBoxManager.draw(it)

            // HUD
            main.hudManager.draw(it)

            customFont.draw(it, "1000 C$", 115f, 2900f)

            customFont.draw(it, "Mês 1", 500f, 2910f)

            customFont.draw(it, "Nv 1", 820f, 2910f)
        }
    }
}
