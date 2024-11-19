package br.com.capyensina.main

import br.com.capyensina.main.database.Database
import br.com.capyensina.main.ui.HudManager
import br.com.capyensina.main.ui.TextBoxManager
import br.com.capyensina.main.ui.layout.HomeLayout
import br.com.capyensina.main.ui.layout.SkinManager
import br.com.capyensina.main.ui.screens.BooksScreen
import br.com.capyensina.main.ui.screens.ConfigScreen
import br.com.capyensina.main.ui.screens.EditScreen
import br.com.capyensina.main.ui.screens.HomeScreen
import br.com.capyensina.main.ui.screens.InvestimentoScreen
import br.com.capyensina.main.ui.screens.LojaScreen
import br.com.capyensina.main.ui.screens.NameScreen
import br.com.capyensina.main.ui.screens.QuizScreen
import br.com.capyensina.main.ui.screens.RpgScreen
import br.com.capyensina.main.ui.screens.ScoreScreen
import br.com.capyensina.main.ui.screens.SplashScreen
import br.com.capyensina.main.ui.screens.StoryScreen
import br.com.capyensina.main.ui.screens.TextScreen
import br.com.capyensina.main.ui.screens.TutorialScreen
import br.com.capyensina.main.ui.screens.debug.DebugScreen
import ktx.app.KtxGame
import ktx.app.KtxScreen
import ktx.async.KtxAsync

class Main : KtxGame<KtxScreen>() {

    val WORLD_HEIGHT = 2992f
    val WORLD_WIDTH = 1344f

    lateinit var skinManager: SkinManager
        private set
    lateinit var homeLayout: HomeLayout
        private set
    lateinit var hudManager: HudManager
        private set
    lateinit var textBoxManager: TextBoxManager
        private set
    //lateinit var database: Database
        //private set

    override fun create() {
        KtxAsync.initiate()

        // Initialize UI utils, at least, must be earlier than Layouts
        skinManager = SkinManager()
        hudManager = HudManager(this)
        textBoxManager = TextBoxManager(this)
        //database = Database(this)

        // Initialize Layouts
        //homeLayout = HomeLayout(this)

        // Initialize Screens
        addScreen(HomeScreen(this))

        // Telas que agora serão popups:
        addScreen(ConfigScreen(this))
        addScreen(BooksScreen(this))
        //addScreen(LojaScreen(this))
        //addScreen(EditScreen(this))

        // TODO Telas que vamos verificar se cabe no escopo do MVP
        //addScreen(RpgScreen(this))
        //addScreen(InvestimentoScreen(this))
        //addScreen(TutorialScreen(this))

        // TODO Telas que falta atualizar (responsividade)
        //addScreen(SplashScreen(this))
        addScreen(TextScreen(this))
        addScreen(QuizScreen(this))
        addScreen(ScoreScreen(this))
        addScreen(NameScreen(this))
        addScreen(StoryScreen(this))

        addScreen(DebugScreen(this))

        // Set start screen, at least, must be after adding screens
        //setScreen<QuizScreen>()
        setScreen<StoryScreen>()
    }
}
