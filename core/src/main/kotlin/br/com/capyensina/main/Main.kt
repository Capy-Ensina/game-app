package br.com.capyensina.main

import br.com.capyensina.main.ui.layout.HomeLayout
import br.com.capyensina.main.ui.layout.SkinManager
import br.com.capyensina.main.ui.screens.BooksScreen
import br.com.capyensina.main.ui.screens.ConfigScreen
import br.com.capyensina.main.ui.screens.EditScreen
import br.com.capyensina.main.ui.screens.HomeScreen
import br.com.capyensina.main.ui.screens.InvestimentoScreen
import br.com.capyensina.main.ui.screens.LojaScreen
import br.com.capyensina.main.ui.screens.RpgScreen
import br.com.capyensina.main.ui.screens.TextScreen
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import ktx.app.KtxGame
import ktx.app.KtxScreen
import ktx.async.KtxAsync

class Main : KtxGame<KtxScreen>() {

    lateinit var skinManager: SkinManager
    lateinit var homeLayout: HomeLayout

    override fun create() {
        KtxAsync.initiate()

        // Initialize UI utils, must at least earlier than Layouts
        skinManager = SkinManager()

        // Initialize Layouts
        //homeLayout = HomeLayout(this) TODO - Malcoln fazer isso funcionar

        // Initialize Screens
        addScreen(HomeScreen(this))
        addScreen(RpgScreen(this))
        addScreen(BooksScreen(this))
        addScreen(EditScreen(this))
        addScreen(LojaScreen(this))
        addScreen(InvestimentoScreen(this))
        addScreen(ConfigScreen(this))
        addScreen(TextScreen(this))



        // Set start screen, must at least be after adding screens
        setScreen<TextScreen>()
    }
}
