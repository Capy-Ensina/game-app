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
import br.com.capyensina.main.ui.screens.QuizScreen
import br.com.capyensina.main.ui.screens.RpgScreen
import br.com.capyensina.main.ui.screens.SplashScreen
import br.com.capyensina.main.ui.screens.TextScreen
import br.com.capyensina.main.ui.screens.TutorialScreen
import br.com.capyensina.main.ui.screens.debug.DebugScreen
import ktx.app.KtxGame
import ktx.app.KtxScreen
import ktx.async.KtxAsync

class Main : KtxGame<KtxScreen>() {

    val WORLD_HEIGHT = 1300f
    val WORLD_WIDTH = 3000f

    lateinit var skinManager: SkinManager
    lateinit var homeLayout: HomeLayout
    lateinit var hudManager: HudManager
    lateinit var textBoxManager: TextBoxManager
    lateinit var database: Database

    override fun create() {
        KtxAsync.initiate()

        // Initialize UI utils, at least, must be earlier than Layouts
        skinManager = SkinManager()
        hudManager = HudManager(this)
        textBoxManager = TextBoxManager(this)
        database = Database(this)

        // Initialize Layouts
        //homeLayout = HomeLayout(this)

        // Initialize Screens
        addScreen(HomeScreen(this))
        addScreen(ConfigScreen(this))/*
        addScreen(RpgScreen(this))
        addScreen(BooksScreen(this))
        addScreen(EditScreen(this))
        addScreen(LojaScreen(this))
        addScreen(InvestimentoScreen(this))
        addScreen(TextScreen(this))
        addScreen(QuizScreen(this))
        addScreen(SplashScreen(this))
        addScreen(TutorialScreen(this))*/
        addScreen(DebugScreen(this))

        // Set start screen, at least, must be after adding screens
        //setScreen<QuizScreen>()
        setScreen<DebugScreen>()
    }
}
