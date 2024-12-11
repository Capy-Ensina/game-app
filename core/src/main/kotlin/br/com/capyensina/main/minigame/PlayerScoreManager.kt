package br.com.capyensina.main.minigame

import br.com.capyensina.main.Main

class PlayerScoreManager(var main: Main) {
    var lastScore: Double = 0.0
    var lastTime: Float = 0f
    var name: String = "_________________"

    fun sendScoreToDatabase() {
        main.database.sendRankingData(name, lastScore.toInt(), lastTime)
    }
}
