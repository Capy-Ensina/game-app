package br.com.capyensina.main.sound

import br.com.capyensina.main.Main
import com.badlogic.gdx.Gdx
import ktx.assets.toInternalFile

class AudioManager(var main: Main) {
    var isMusicOn = true
    var isSoundOn = true

    private var music = Gdx.audio.newMusic("music/capyEnsinaTheme.mp3".toInternalFile())

    private var lose = Gdx.audio.newSound("SFX/lose_1.wav".toInternalFile())
    private var win = Gdx.audio.newSound("SFX/win_1.wav".toInternalFile())

    private var pop = Gdx.audio.newSound("SFX/pop_1.mp3".toInternalFile())
    private var click = Gdx.audio.newSound("SFX/click_1.mp3".toInternalFile())

    private var confirmOne = Gdx.audio.newSound("SFX/confirm_1.mp3".toInternalFile())
    private var confirmTwo = Gdx.audio.newSound("SFX/confirm_2.mp3".toInternalFile())
    private var confirmThree = Gdx.audio.newSound("SFX/confirm_3.mp3".toInternalFile())
    private var confirms = listOf(confirmOne, confirmTwo, confirmThree)

    private var isMusicPlaying = false

    init {
        music.isLooping = true
        music.volume = 0.5f
    }

    fun playCoin() {
        if (!isSoundOn) return

    }

    fun playClick(){
        if (!isSoundOn) return
        click.play()
    }

    fun playConfirm(){
        if (!isSoundOn) return
        confirms[(0..confirms.size).random()].play()
    }

    fun playPop(){
        if (!isSoundOn) return
        pop.play()
    }

    fun playLose(){
        if (!isSoundOn) return
        lose.play()
    }

    fun playWin(){
        if (!isSoundOn) return
        win.play()
    }

    fun startMusic(){
        if (!isMusicOn) return
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
