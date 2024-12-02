package br.com.capyensina.main

import br.com.capyensina.main.minigame.PlayerScoreManager
import br.com.capyensina.main.minigame.quiz.QuizManager
import br.com.capyensina.main.ui.AnimationManager
import br.com.capyensina.main.ui.HudManager
import br.com.capyensina.main.ui.TextBoxManager
import br.com.capyensina.main.ui.screens.HomeScreen
import br.com.capyensina.main.ui.screens.NameScreen
import br.com.capyensina.main.ui.screens.QuizScreen
import br.com.capyensina.main.ui.screens.ScoreScreen
import br.com.capyensina.main.ui.screens.SplashScreen
import br.com.capyensina.main.ui.screens.StoryScreen
import br.com.capyensina.main.ui.screens.TextScreen
import br.com.capyensina.main.ui.screens.debug.DebugScreen
import ktx.app.KtxGame
import ktx.app.KtxScreen
import ktx.async.KtxAsync

class Main : KtxGame<KtxScreen>() {

    val WORLD_HEIGHT = 2992f
    val WORLD_WIDTH = 1344f

    lateinit var hudManager: HudManager
        private set
    lateinit var textBoxManager: TextBoxManager
        private set
    lateinit var playerScoreManager: PlayerScoreManager
        private set
    lateinit var quizManager: QuizManager
        private set
    lateinit var animationManager: AnimationManager
        private set
    //lateinit var database: Database
        //private set

    override fun create() {
        KtxAsync.initiate()

        // Initialize UI utils, at least, must be earlier than Layouts
        playerScoreManager = PlayerScoreManager(this) // must be first

        hudManager = HudManager(this)
        textBoxManager = TextBoxManager(this)
        quizManager = QuizManager()
        animationManager = AnimationManager(this)
        //database = Database(this)

        // Initialize Screens
        addScreen(HomeScreen(this))
        addScreen(SplashScreen(this))
        addScreen(TextScreen(this))
        addScreen(QuizScreen(this))
        addScreen(ScoreScreen(this))
        addScreen(NameScreen(this))
        addScreen(StoryScreen(this))

        addScreen(DebugScreen(this))

        // Set start screen, at least, must be after adding screens
        setScreen<SplashScreen>()
    }

    override fun render() {
        logic()
        super.render()
    }

    private fun logic(){
        animationManager.logic()
    }
}
