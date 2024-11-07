package br.com.capyensina.main

import br.com.capyensina.main.ui.screens.BooksScreen
import br.com.capyensina.main.ui.screens.EditScreen
import br.com.capyensina.main.ui.screens.HomeScreen
import br.com.capyensina.main.ui.screens.InvestimentoScreen
import br.com.capyensina.main.ui.screens.LojaScreen
import br.com.capyensina.main.ui.screens.RpgScreen
import ktx.app.KtxGame
import ktx.app.KtxScreen
import ktx.async.KtxAsync

class Main : KtxGame<KtxScreen>() {

    override fun create() {
        KtxAsync.initiate()

        addScreen(HomeScreen(this))
        addScreen(RpgScreen(this))
        addScreen(BooksScreen(this))
        addScreen(EditScreen(this))
        addScreen(LojaScreen(this))
        addScreen(InvestimentoScreen(this))

        setScreen<BooksScreen>()
    }
}
