package br.com.capyensina.main.ui.screens.debug

import br.com.capyensina.main.Main
import br.com.capyensina.main.components.Clickable
import br.com.capyensina.main.minigame.quiz.QuizManager
import br.com.capyensina.main.minigame.quiz.QuizQuestion
import br.com.capyensina.main.minigame.quiz.QuizQuestions
import br.com.capyensina.main.ui.screens.HomeScreen
import br.com.capyensina.main.ui.screens.ScoreScreen
import br.com.capyensina.main.util.AssetManager
import br.com.capyensina.main.util.ColorTheme
import br.com.capyensina.main.util.MySpriteBatch
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.utils.viewport.ExtendViewport
import ktx.app.KtxScreen
import ktx.assets.file
import ktx.graphics.use

class DebugScreen(mainGame: Main) : KtxScreen {

    /* NOTA 17/11/2024 20:04 - Malcoln
     * Testas suas coisas aqui, para evitar deixar código desnecessário nas telas que já estão
     * prontas, e já fica o aviso TUDO aqui pode ser apagado a qualquer momento, então não deixe nada
     * relevante "salvo" nessa tela
     */

    private val batch = MySpriteBatch()
    private val main = mainGame

    private val customFont = AssetManager.getFont()

    private val camera = OrthographicCamera()
    private val viewport = ExtendViewport(main.WORLD_WIDTH, main.WORLD_HEIGHT, camera)

    private val quizManager = QuizManager(4)

    private var quizIndex = 0
    private var score = 0.0

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
        resize(Gdx.graphics.width, Gdx.graphics.height)
    }

    override fun render(delta: Float) {
        camera.update()
        batch.projectionMatrix = camera.combined

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
            main.hudManager.input(worldPos)

            // Verifica cliques nos popups
            main.textBoxManager.input(worldPos)

            quizManager.getActualQuestion().input(worldPos)

            if (skipButton.collider.contains(worldPos)) skipButton.action()
        }
    }

    fun logic(){

    }

    fun draw(){
        Gdx.gl.glClearColor(
            ColorTheme.TEXT_BACKGROUND_COLOR.r,
            ColorTheme.TEXT_BACKGROUND_COLOR.g,
            ColorTheme.TEXT_BACKGROUND_COLOR.b,
            ColorTheme.TEXT_BACKGROUND_COLOR.a
        )
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        batch.use {
            main.hudManager.drawTextScreen(it, ColorTheme.GREEN)

            customFont.draw(it, "QUIZ", 550f, 2900f)

            quizManager.getActualQuestion().draw(it)

            customFont.draw(it, "SCORE: $score", 550f, 2700f)

            it.draw(skipButton)

            main.textBoxManager.draw(it)
        }
    }

    private fun nextQuestion(){
        if (!quizManager.nextQuestion()) {
            score = quizManager.score
            main.playerScoreManager.lastScore = score
            main.textBoxManager.updateScoreText()
            main.textBoxManager.scoreTextBox.isActive = true
        }
    }

}
