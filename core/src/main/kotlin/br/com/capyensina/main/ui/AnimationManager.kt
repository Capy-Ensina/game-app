package br.com.capyensina.main.ui

import br.com.capyensina.main.Main
import com.badlogic.gdx.Gdx

class AnimationManager(var main: Main) {
    var elapsed: Float = 0f
        private set

    fun logic(){
        elapsed += Gdx.graphics.deltaTime
    }

}
