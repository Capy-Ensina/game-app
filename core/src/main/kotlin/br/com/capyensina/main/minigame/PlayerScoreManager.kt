package br.com.capyensina.main.minigame

import br.com.capyensina.main.Main

class PlayerScoreManager(var main: Main) {
    var lastScore: Double = 0.0
    var lastTime: Int = 0
    var name: String = "" // todo Malcoln - Descobre como salva o nome do jogador

    fun sendScoreToDatabase() {

    }
}
