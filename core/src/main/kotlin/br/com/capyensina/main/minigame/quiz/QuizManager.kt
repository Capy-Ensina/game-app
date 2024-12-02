package br.com.capyensina.main.minigame.quiz

import kotlin.random.Random

class QuizManager() {

    private var actualQuestionIndex: Int = 0
    private var quiz: List<QuizQuestion>
    var score = 0.0
        private set
    private var isRunning = true
    private var numberOfQuestions = 1

    init {
        regenerateQuestions(numberOfQuestions)

        if (numberOfQuestions > QuizQuestions.questions.size)
        { numberOfQuestions = QuizQuestions.questions.size }

        quiz = generateQuiz()
    }

    private fun generateQuiz(): List<QuizQuestion>{
        val list = emptyList<QuizQuestion>().toMutableList()

        for (index in getRandomList(numberOfQuestions, QuizQuestions.questions.size)){
            list += QuizQuestions.questions[index]
        }

        return list.toList()
    }

    fun getActualQuestion(): QuizQuestion{
        return quiz[actualQuestionIndex]
    }

    private fun getRandomList(tam: Int, lim: Int): List<Int> {
        require(tam <= lim)

        val numbers = mutableSetOf<Int>()

        while (numbers.size < tam) {
            val number = Random.nextInt(lim)
            numbers.add(number)
        }

        return numbers.toList()
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

    fun regenerateQuestions(numberOfQuestions: Int){
        this.numberOfQuestions = numberOfQuestions

        quiz = generateQuiz()
        score = 0.0
        isRunning = true
        actualQuestionIndex = 0

        for (question in quiz){
            question.unselectAnswer()
        }
    }
}
