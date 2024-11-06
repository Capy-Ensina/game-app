package br.com.capyensina.main

import br.com.capyensina.main.ui.screens.HomeScreen
import ktx.app.KtxGame
import ktx.app.KtxScreen
import ktx.async.KtxAsync

class Main : KtxGame<KtxScreen>() {

    override fun create() {
        KtxAsync.initiate()

        addScreen(HomeScreen(this))
        setScreen<HomeScreen>()


    }
}
