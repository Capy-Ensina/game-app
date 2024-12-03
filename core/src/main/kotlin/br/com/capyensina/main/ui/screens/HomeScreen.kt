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
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.utils.viewport.ExtendViewport


class HomeScreen(mainGame: Main) : KtxScreen {
    private val batch = MySpriteBatch()
    private val main = mainGame

    private val camera = OrthographicCamera()
    private val viewport = ExtendViewport(main.WORLD_WIDTH, main.WORLD_HEIGHT, camera)

    private val image1 = Clickable(
        AssetManager.closeButton,
        Rectangle(0f , 0f, 100f, 100f)
    )


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
            it.draw(image1)




            // PopUP - deve ser desenhado por último, mas antes da HUD
            main.textBoxManager.draw(it)

            // HUD
            main.hudManager.draw(it)
        }
    }
}
