package br.com.capyensina.main.util

import br.com.capyensina.main.Main
import com.badlogic.gdx.Input.TextInputListener

class MyTextInputListener(var main: Main) : TextInputListener {
    override fun input(text: String) {
        main.playerScoreManager.name = text
    }

    override fun canceled() {

    }
}
