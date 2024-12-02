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
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import ktx.app.KtxScreen
import ktx.assets.disposeSafely
import ktx.assets.toInternalFile
import ktx.graphics.use
import com.badlogic.gdx.graphics.g2d.GlyphLayout
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.utils.viewport.ExtendViewport

/* Nota Malcoln 02/12 09:54
 * Não apaga essa linha kkkkkkkkkkkkkk
 * de verdade, isso aqui tá sendo usado em mta parte do código, e esqueci de mudar, então agora vida
 * que segue :p
 */
val layout = GlyphLayout() // trem dos textos longos com quebra de linha

class TextScreen(mainGame: Main) : KtxScreen {
    val main = mainGame
    private val batch = MySpriteBatch()
    private val shapeRenderer = ShapeRenderer()
    private val font = BitmapFont()

    private val customFont = AssetManager.getFont()
    private val customFontBold = AssetManager.getFontTextBold()
    private val customFontText = AssetManager.getFontText()

    private val camera = OrthographicCamera()
    private val viewport = ExtendViewport(main.WORLD_WIDTH, main.WORLD_HEIGHT, camera)

    // Retângulos
    private val hudTopColor = ColorTheme.ORANGE

    private val finalizarbutton = Clickable(
        AssetManager.finishButton,
        Rectangle(320f, 70f, 700f, 400f)
    ) { main.setScreen<QuizScreen>(); main.quizManager.regenerateQuestions(5) }

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

    override fun dispose() {
        batch.disposeSafely()
        shapeRenderer.dispose()
        font.disposeSafely()
        customFont.disposeSafely()
        finalizarbutton.disposeSafely()
    }

    private fun input() {
        if (Gdx.input.justTouched()) {
            // Transforma o click na tela em uma posição dentro do mundo
            val worldPos = viewport.unproject(Vector2(Gdx.input.x.toFloat(), Gdx.input.y.toFloat()))

            if (finalizarbutton.collider.contains(worldPos)) finalizarbutton.action()
        }
    }

    override fun resize(width: Int, height: Int) {
        viewport.update(width, height)
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

            it.draw(finalizarbutton)

            customFont.draw(it, "INTRODUÇÃO I", 330f, 2900f)
            customFontBold.draw(it, "Capivaras do Tesouro", 300f, 2650f)

            // para textos grandes
            val text = "A educação financeira é essencial para o desenvolvimento de habilidades que permitem gerenciar recursos de forma consciente e eficiente. Ela envolve a compreensão de conceitos fundamentais, como planejamento financeiro, controle de gastos, investimentos, e a importância de poupar para o futuro. Ao adquirir conhecimentos sobre como lidar com o dinheiro, as pessoas podem tomar decisões mais informadas, evitando dívidas excessivas e aproveitando melhor suas oportunidades econômicas."

            val textWidth = 1200f
            val x = 60f
            val y = 2470f

            layout.setText(customFontText, text, Color.BLACK, textWidth, -1, true)

            customFontText.draw(batch, layout, x, y)
        }
    }
}
