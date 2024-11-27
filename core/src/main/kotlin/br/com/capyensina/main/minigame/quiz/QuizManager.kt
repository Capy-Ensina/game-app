package br.com.capyensina.main.minigame.quiz

class QuizManager(
    var numberOfQuestions: Int,
    var minDifficulty: Int = 1,
    var maxDifficulty: Int = 100
) {

    private var actualQuestionIndex: Int = 0
    private var quiz: List<QuizQuestion>
    var score = 0.0
        private set
    private var isRunning = true

    init {
        quiz = generateQuiz()
    }


    private fun generateQuiz(): List<QuizQuestion>{
        return QuizQuestions.questions
    }

    fun getActualQuestion(): QuizQuestion{
        return quiz[actualQuestionIndex]
    }

    fun nextQuestion(): Boolean{
        if (actualQuestionIndex < numberOfQuestions-1 && isRunning) {
            score += quiz[actualQuestionIndex].getScore()
            actualQuestionIndex++
            return true
        } else if (isRunning) {
            score += quiz[actualQuestionIndex].getScore()
            isRunning = false
            return false
        } else return false
    }
}
