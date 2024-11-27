package br.com.capyensina.main.minigame.quiz

object QuizQuestions {

    val questions = listOf(
        QuizQuestion(
            id = 1,
            subject = "finanças",
            questionText = "Por que educação financeira é importante?",
            answerTable = QuizAnswerTable(
                answerA = "Porque capivaras gostam de dinheiro.",
                answerB = "Para aprender a gerir o próprio dinheiro.",
                answerC = "Porque capivaras são capitalistas.",
                answerD = "Porque o apocapivaras está chegando.",
                correctIndex = 1
            ),
            difficulty = 1
        ),
        QuizQuestion(
            id = 2,
            subject = "finanças",
            questionText = "O que é uma despesa?",
            answerTable = QuizAnswerTable(
                answerA = "Perder dinheiro.",
                answerB = "Gasto com uma necessidade.",
                answerC = "O contrário de custo.",
                answerD = "É o mesmo que custo.",
                correctIndex = 1
            ),
            difficulty = 1
        ),
        QuizQuestion(
            id = 3,
            subject = "finanças",
            questionText = "O que é uma despesa?",
            answerTable = QuizAnswerTable(
                answerA = "Perder dinheiro.",
                answerB = "Gasto com uma necessidade.",
                answerC = "O contrário de custo.",
                answerD = "É o mesmo que custo.",
                correctIndex = 1
            ),
            difficulty = 1
        ),
        QuizQuestion(
            id = 4,
            subject = "finanças",
            questionText = "O que é um custo?",
            answerTable = QuizAnswerTable(
                answerA = "Perder dinheiro.",
                answerB = "Gasto com uma necessidade.",
                answerC = "O contrário de custo.",
                answerD = "EU SOU A CERTA.",
                correctIndex = 3
            ),
            difficulty = 1
        ),
    )

    fun getQuestionsLength(): Int { return questions.size }
}
