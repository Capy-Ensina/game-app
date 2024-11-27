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

class QuizScreen (mainGame: Main) : KtxScreen {
    val main = mainGame

    private val batch = MySpriteBatch()
    private val font = BitmapFont()
    private val customFont = AssetManager.getFont()
    private val customFontBold = AssetManager.getFontTextBold()
    private val customFontText = AssetManager.getFontText()

    private val camera = OrthographicCamera()
    private val viewport = ExtendViewport(main.WORLD_WIDTH, main.WORLD_HEIGHT, camera)

    private val actualQuestion = 1
    private val totalQuestion = 1


    // Retângulos
    private val hudTopColor = ColorTheme.GREEN

    //private val backgroundamarelo = Texture("bg/backgroundamarelo.png".toInternalFile())

    //imagens da interface
    private val redquestion = Texture("button/redquestion.png".toInternalFile())
    private val blueaswerA = Texture("button/blueanswerA.png".toInternalFile())
    private val blueaswerB = Texture("button/blueanswerB.png".toInternalFile())
    private val blueaswerC = Texture("button/blueanswerC.png".toInternalFile())
    private val blueaswerD = Texture("button/blueanswerD.png".toInternalFile())

    private val skipButton = Clickable(
        AssetManager.skipButton,
        Rectangle(650f, 30f, 900f, 900f)
    ) { nextQuestion() }

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
        redquestion.disposeSafely()
        blueaswerA.disposeSafely()
        blueaswerB.disposeSafely()
        blueaswerC.disposeSafely()
        blueaswerD.disposeSafely()
        skipButton.disposeSafely()
    }

    private fun input() {
        if (Gdx.input.justTouched()) {
            // Transforma o click na tela em uma posição dentro do mundo
            val worldPos = viewport.unproject(Vector2(Gdx.input.x.toFloat(), Gdx.input.y.toFloat()))

            if (skipButton.collider.contains(worldPos)) skipButton.action()
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

        val deslocamentoY = -200f
        val deslocamentoX = -100f
        val aumento = 1.2f

        batch.use {
            main.hudManager.drawTextScreen(it, hudTopColor)

            /*//questao um  -> posicoes antigas
            it.draw(redquestion, 120f, 2200f, 1100f, 400f)
            it.draw(blueaswerA, 160f, 1960f, 950f, 350f)
            it.draw(blueaswerB, 160f, 1700f, 930f, 350f)
            it.draw(blueaswerC, 160f, 1440f, 930f, 350f)
            it.draw(blueaswerD, 160f, 1240f, 950f, 300f)*/

            it.draw(redquestion, 120f + deslocamentoX, 2200f + deslocamentoY, 1100f * aumento, 400f * aumento)
            it.draw(blueaswerA,
                160f + deslocamentoX,
                1960f + deslocamentoY - (50f * aumento),
                950f * aumento,
                350f * aumento
            )
            it.draw(blueaswerB, 160f + deslocamentoX, 1700f + deslocamentoY - (100f * aumento), 930f * aumento, 350f * aumento)
            it.draw(blueaswerC, 160f + deslocamentoX, 1440f + deslocamentoY - (150f * aumento), 930f * aumento, 350f * aumento)
            it.draw(blueaswerD, 160f + deslocamentoX, 1240f + deslocamentoY - (200f * aumento), 950f * aumento, 300f * aumento)

            it.draw(skipButton) // botao para passar a proxima pergunta

            /*// questao dois
            it.draw(redquestion, 120f, 900f, 1100f, 400f)
            it.draw(blueaswerA, 160f, 660f, 950f, 350f)
            it.draw(blueaswerB, 160f, 400f, 930f, 350f)
            it.draw(blueaswerC, 160f, 140f, 930f, 350f)
            it.draw(blueaswerD, 160f, -65f, 950f, 300f)*/

        }

        batch.use {
            customFont.draw(it, "QUIZ", 550f, 2900f)

        }

        // Questao 1
        batch.use {
            val text = "Por que educação financeira é importante?"


            val textWidth = 900f
            val x = 450f + deslocamentoX
            val y = 2520f + deslocamentoY

            layout.setText(customFontBold, text, Color.BLACK, textWidth, -1, true)

            customFontBold.draw(batch, layout, x, y)
        }

        // Resposta A
        batch.use {
            //val text = "Porque capivaras gostam de dinheiro."
            val text = "M".repeat(32)

            val textWidth = 750f
            val x = 420f + deslocamentoX
            val y = 2180f + deslocamentoY

            layout.setText(customFontBold, text, Color.BLACK, textWidth, -1, true)

            customFontBold.draw(batch, layout, x, y)
        }

        // Resposta B
        batch.use {
            val text = "Para aprender gerir o próprio dinheiro."

            val textWidth = 800f
            val x = 420f + deslocamentoX
            val y = 1870f + deslocamentoY

            layout.setText(customFontBold, text, Color.BLACK, textWidth, -1, true)

            customFontBold.draw(batch, layout, x, y)
        }

        // Resposta C
        batch.use {
            val text = "Porque capivaras são capitalistas."

            val textWidth = 800f
            val x = 420f + deslocamentoX
            val y = 1550f + deslocamentoY

            layout.setText(customFontBold, text, Color.BLACK, textWidth, -1, true)

            customFontBold.draw(batch, layout, x, y)
        }

        // Resposta D
        batch.use {
            val text = "Por que apocapivaras está chegando."

            val textWidth = 800f
            val x = 420f + deslocamentoX
            val y = 1240f + deslocamentoY

            layout.setText(customFontBold, text, Color.BLACK, textWidth, -1, true)

            customFontBold.draw(batch, layout, x, y)
        }

    }

    private fun nextQuestion(){
        if (actualQuestion >= totalQuestion) {
            main.setScreen<ScoreScreen>()
        }
    }
}
