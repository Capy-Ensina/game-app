package br.com.capyensina.main.ui.screens

import br.com.capyensina.main.Main
import br.com.capyensina.main.util.AssetManager
import br.com.capyensina.main.util.ColorTheme
import br.com.capyensina.main.util.MySpriteBatch
import ktx.app.KtxScreen
import ktx.assets.disposeSafely
import ktx.graphics.use
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.utils.viewport.ExtendViewport
import ktx.assets.toInternalFile


class BooksScreen(mainGame: Main) : KtxScreen {
    private val batch = MySpriteBatch()
    private val shapeRenderer = ShapeRenderer()
    private val main = mainGame

    private val camera = OrthographicCamera()
    private val viewport = ExtendViewport(main.WORLD_WIDTH, main.WORLD_HEIGHT, camera)

    //interface tela
    private val infoboxdois = Texture("text-box/infoboxdois.png".toInternalFile())
    private val redbutton = Texture("button/redbutton.png".toInternalFile()) // botao de opcoes dos modulos
    private val closebutton = Texture("button/closebutton.png".toInternalFile())
    private val customFont = AssetManager.getFont()
    private val customFontBold = AssetManager.getFontTextBold()
    private val customFontText = AssetManager.getFontText()

    /* A camera precisa ser posicionada de modo que a tela inteira seja visivel, ou seja,
     * no meio da viewport
     */
    init {
        camera.position.set(
            mainGame.WORLD_WIDTH/2,
            mainGame.WORLD_HEIGHT/2,
            0f
        )
        viewport.apply()
    }

    override fun render(delta: Float) {
        // Atualiza os valores da câmera, e manda o batch e o shapeRenderer usarem ela
        camera.update()
        batch.projectionMatrix = camera.combined
        shapeRenderer.projectionMatrix = camera.combined

        input()
        logic()
        draw()

        batch.use {
        }

    }

    // Sempre que "mudar de tamanho" a viewport PRECISA ser atualizada
    override fun resize(width: Int, height: Int) {
        viewport.update(width, height)
    }

    override fun dispose() {
        batch.disposeSafely()
        shapeRenderer.disposeSafely()
        infoboxdois.disposeSafely()
        redbutton.disposeSafely()
        closebutton.disposeSafely()
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


            // PopUP - deve ser desenhado por último, mas antes da HUD
            main.textBoxManager.draw(it)
        }


        // HUD - Ultima coisa a ser desenhada na tela, ficando acima de tudo
        shapeRenderer.use(ShapeRenderer.ShapeType.Filled) {
            /* NOTA 18/11/2024 15:46 - Malcoln
             * Talvez possa ser interessante não desenhar a forma, mas sim deixar "transparente"
             * já que ao limpar a tela, o fundo está ficando completamente azul.
             */
            main.hudManager.drawShape(it)
        }

        // HUD - Desenhando botões
        batch.use {
            main.hudManager.draw(it)
        }

        batch.use{
            it.draw(infoboxdois, 5f, 700f, 1350f, 1350f)
            it.draw(redbutton, 200f, 1350f, 950f, 400f)
            it.draw(redbutton, 200f, 1100f, 950f, 400f)
            it.draw(redbutton, 200f, 850f, 950f, 400f)
            it.draw(closebutton, 1000f, 1660f, 400f, 400f)

            customFont.draw(it, "MÓDULO I", 400f, 1790f)
            customFontBold.draw(it, "Finanças I", 500f, 1590f)
            customFontBold.draw(it, "Economia I", 500f, 1350f)
            customFontBold.draw(it, "Investimento I", 400f, 1090f)
        }
    }
}
