package br.com.capyensina.main.minigame.quiz

class QuizAnswerTable (
    val answerA: String,
    val answerB: String,
    val answerC: String,
    val answerD: String,
    val correctIndex: Int
){
    var selected = mutableListOf(false, false, false, false)

    fun selectAnswer(index: Int) {
        selected = mutableListOf(false, false, false, false)
        selected[index] = true
    }

    fun unselectAnswer(){
        selected = mutableListOf(false, false, false, false)
    }

    fun isCorrect(): Boolean{
        return selected[correctIndex]
    }

    fun getAnswerList(): List<String>{
        return listOf(answerA, answerB, answerC, answerD)
    }

    operator fun iterator(): Iterator<String> = listOf(answerA, answerB, answerC, answerD).iterator()

}
