package br.com.capyensina.main.sound

import br.com.capyensina.main.Main
import com.badlogic.gdx.Gdx
import ktx.assets.toInternalFile

class AudioManager(var main: Main) {

    private var music = Gdx.audio.newMusic("bgm-principal.mp3".toInternalFile())
    private var isMusicPlaying = false

    init {
        music.isLooping = true
    }

    fun playCoin() {

    }

    fun playClick(){

    }

    fun startMusic(){
        if (isMusicPlaying) return
        music.play()
        isMusicPlaying = true
    }

    fun stopMusic(){
        if (!isMusicPlaying) return
        music.stop()
        isMusicPlaying = false
    }


}
